package lotto.domain;

import static lotto.enums.ErrorMessage.INVALID_AMOUNT_UNIT;
import static lotto.enums.ErrorMessage.NOT_ENOUGH_AMOUNT;
import static lotto.enums.LottoConfig.LOTTO_PRICE;

public record Amount(int amount) {
    private static final int ZERO = 0;
    private static final int PERCENT = 100;

    public Amount {
        validateLottoPrice(amount);
        validateAmountUnit(amount);
    }

    private void validateLottoPrice(final int amount) {
        if (amount < LOTTO_PRICE.getValue()) {
            throw new IllegalArgumentException(NOT_ENOUGH_AMOUNT.getMassage());
        }
    }

    private void validateAmountUnit(final int amount) {
        if (amount % LOTTO_PRICE.getValue() != ZERO) {
            throw new IllegalArgumentException(INVALID_AMOUNT_UNIT.getMassage());
        }
    }

    public int getLottoQuantity() {
        return amount / LOTTO_PRICE.getValue();
    }

    public double calculateYield(final int winningAmount) {
        return (double) winningAmount / this.amount() * PERCENT;
    }
}
