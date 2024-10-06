package Assignment2;

import java.util.ArrayList;
import java.util.List;

public class CompositeAccount implements AccountComponent {
    private String compositeName;
    private List<AccountComponent> accounts = new ArrayList<>();

    public CompositeAccount(String compositeName) {
        this.compositeName = compositeName;
    }

    public void addAccount(AccountComponent account) {
        accounts.add(account);
    }

    public void removeAccount(AccountComponent account) {
        accounts.remove(account);
    }

    @Override
    public void pay(double amount) {
        System.out.println("Payment from composite account " + compositeName + ":");
        for (AccountComponent account : accounts) {
            account.pay(amount / accounts.size());
        }
    }

    @Override
    public double getRemainingBalance() {
        double totalRemaining = 0;
        for (AccountComponent account : accounts) {
            totalRemaining += account.getRemainingBalance();
        }
        return totalRemaining;
    }

    @Override
    public double getSpentAmount() {
        double totalSpent = 0;
        for (AccountComponent account : accounts) {
            totalSpent += account.getSpentAmount();
        }
        return totalSpent;
    }
}
