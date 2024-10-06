package Assignment2;

public class IndividualAccount implements AccountComponent {
    private String accountName;
    private double totalAmount;
    private double spentAmount;

    public IndividualAccount(String accountName, double totalAmount) {
        this.accountName = accountName;
        this.totalAmount = totalAmount;
        this.spentAmount = 0;
    }

    @Override
    public void pay(double amount) {
        if (amount <= getRemainingBalance()) {
            spentAmount += amount;
            System.out.println("Paid " + amount + " tenge for " + accountName);
        } else {
            System.out.println("Insufficient funds in " + accountName + " account");
        }
    }

    @Override
    public double getRemainingBalance() {
        return totalAmount - spentAmount;
    }

    @Override
    public double getSpentAmount() {
        return spentAmount;
    }
}
