package lotto.core;

import lotto.common.PureNumber;

public class PurchaseAmount {

    private static int LOTTERY_TICKET_PRICE = 1000;

    private int amount;

    public static PurchaseAmount amountOf(PureNumber number) throws IllegalArgumentException {
        return new PurchaseAmount(number.getNumber());
    }

    public PurchaseAmount(int amount) throws IllegalArgumentException {
        validate(amount);
        this.amount = amount;
    }

    public int getTicketQuantity() {
        return this.amount / LOTTERY_TICKET_PRICE;
    }

    private void validate(int amount) throws IllegalArgumentException {
        if (amount % LOTTERY_TICKET_PRICE != 0) {
            throw new IllegalArgumentException();
        }
    }
}
