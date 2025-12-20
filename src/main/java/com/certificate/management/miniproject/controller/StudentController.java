package com.certificate.management.miniproject.controller;

import com.certificate.management.miniproject.model.Student;
import com.certificate.management.miniproject.repository.StudentRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    private final StudentRepository repository;

    public StudentController(StudentRepository repository) {
        this.repository = repository;
    }

    @PostMapping
    public ResponseEntity<Object> registerStudent(@RequestBody Student student) {

        if (student.getName() == null || student.getName().isEmpty()) {
            return new ResponseEntity<>("Name must not be empty", HttpStatus.BAD_REQUEST);
        }
        if (student.getCourse() == null || student.getCourse().isEmpty()) {
            return new ResponseEntity<>("Course must not be empty", HttpStatus.BAD_REQUEST);
        }


        if (repository.existsById(student.getId())) {
            return new ResponseEntity<>("Student with ID " + student.getId() + " already exists", HttpStatus.CONFLICT);

        }


        repository.save(student);


        return new ResponseEntity<>(student, HttpStatus.CREATED);
    }


    @GetMapping
    public ResponseEntity<List<Student>> getAllStudents() {
        List<Student> students = repository.findAll();
        return new ResponseEntity<>(students, HttpStatus.OK);
    }


    @GetMapping("/{id}")
    public ResponseEntity<Object> getStudentById(@PathVariable int id) {
        Student student = (Student) repository.findById(id);

        if (student != null) {
            return new ResponseEntity<>(student, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Student with ID " + id + " not found", HttpStatus.NOT_FOUND);
        }
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable int id) {
        boolean deleted = repository.deleteById(id);

        if (deleted) {
            return new ResponseEntity<>("Student with ID " + id + " deleted successfully", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Student with ID " + id + " not found", HttpStatus.NOT_FOUND);
        }
    }
}
