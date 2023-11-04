package lotto;

public class PurchaseAmount {

    private static int LOTTERY_TICKET_PRICE = 1000;

    private int amount;

    public PurchaseAmount(int amount) throws IllegalArgumentException {
        validate(amount);
        this.amount = amount;
    }

    private void validate(int amount) throws IllegalArgumentException {
        if (amount % LOTTERY_TICKET_PRICE != 0) {
            throw new IllegalArgumentException();
        }
    }
}
