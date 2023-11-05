package lotto.domain;

public class Cash {
    private static final int LOTTO_PRICE = 1000;

    Integer amount;

    public Cash(Integer amount) {
        validate(amount);
        this.amount = amount;
    }

    private void validate(Integer amount) {
        if (amount % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException();
        }
    }
}
