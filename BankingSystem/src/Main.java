public class Main {
    public static void main(String[] args) {

       
        BankAccount acc1 = new BankAccount("ACC1001", "Shubham Singh", 5000);
        acc1.deposit(2000);
        acc1.withdraw(1500);
        acc1.printDetails();

      
        SavingsAccount sav1 = new SavingsAccount("SAV2001", "Shubham Singh", 10000, 0.05);

        sav1.deposit(5000);
        sav1.withdraw(2000);
        sav1.withdraw(20000);   
        sav1.applyInterest();
        sav1.printDetails();
    }
}
