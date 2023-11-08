package lotto.domain.model;


import static lotto.domain.LottoConfig.*;

public class Money {

    private final int amount;

    public Money(final int amount) {
        validatePositive(amount);
        validateDivisibility(amount);
        this.amount = amount;
    }

    private void validatePositive(int amount) {
        if (amount <= ZERO.getValue()) {
            throw new IllegalArgumentException(
                    LottoErrorMessages.NEGATIVE_AMOUNT.getMessage());
        }
    }

    private void validateDivisibility(int amount) {
        if (amount % LOTTO_PRICE.getValue() != ZERO.getValue()) {
            throw new IllegalArgumentException(
                    LottoErrorMessages.NOT_DIVISIBLE_AMOUNT.getMessage());
        }
    }

    public int calculateLottoCount() {
        return this.amount / LOTTO_PRICE.getValue();
    }

    public int getAmount() {
        return amount;
    }
}
