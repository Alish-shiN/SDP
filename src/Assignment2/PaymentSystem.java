package Assignment2;

public class PaymentSystem {
    public static void main(String[] args) {
        IndividualAccount electricityBill = new IndividualAccount("Electricity", 500);
        IndividualAccount internetBill = new IndividualAccount("Internet", 300);

        CompositeAccount householdAccount = new CompositeAccount("Household Account");
        householdAccount.addAccount(electricityBill);
        householdAccount.addAccount(internetBill);

        electricityBill.pay(200);
        System.out.println("Remaining balance for electricity: " + electricityBill.getRemainingBalance() + " tenge.");

        householdAccount.pay(150);
        System.out.println("Remaining balance for composite account: " + householdAccount.getRemainingBalance() + " tenge.");
    }
}
