class SavingsAccount extends BankAccount {

    private double interestRate; 

    public SavingsAccount(String accountNumber, String accountHolder, double balance, double interestRate) {
        super(accountNumber, accountHolder, balance);
        this.interestRate = interestRate;
    }

    
    @Override
    public void withdraw(double amount) {
        if (amount > 0 && amount <= getBalance()) {
            double newBalance = getBalance() - amount;
            setBalance(newBalance);
            System.out.println(amount + " withdrawn from Savings Account.");
        } else {
            System.out.println("Savings Withdrawal failed! Cannot withdraw more than balance.");
        }
    }

    public void applyInterest() {
        double interest = getBalance() * interestRate;
        setBalance(getBalance() + interest);
        System.out.println("Interest applied: ₹" + interest);
    }
}

