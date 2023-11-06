package lotto.domain;

public class Money {
    private static final int LOTTO_PRICE = 1000;
    private final int amount;

    public Money(int amount) {
        validate(amount);
        this.amount = amount;
    }

    public int getAmount() {
        return amount;
    }

    private void validate(int amount) {
        if (amount < LOTTO_PRICE) {
            throw new IllegalArgumentException();
        }
        if (amount % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException();
        }
    }
}
