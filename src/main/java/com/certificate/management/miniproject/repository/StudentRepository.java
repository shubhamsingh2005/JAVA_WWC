package com.certificate.management.miniproject.repository;

import com.certificate.management.miniproject.model.Student;
import org.springframework.stereotype.Repository;
import java.util.*;

@Repository
public class StudentRepository {

    public Map<Integer, Student> studentDB = new HashMap<>();

    public boolean existsById(int id) {
        return studentDB.containsKey(id);
    }

    public void save(Student student) {
        studentDB.put(student.getId(), student);
    }

    public List<Student> findAll() {
        return new ArrayList<>(studentDB.values());
    }

 public List<Student> findById(int id){
        return new ArrayList<>(studentDB.values());
 }
     public boolean deleteById(int id) {
        return studentDB.remove(id) != null;
    }
}

