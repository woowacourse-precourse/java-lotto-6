package lotto.model;

import static lotto.constant.ErrorMessage.MONEY_LESS_THAN_ZERO;
import static lotto.constant.ErrorMessage.MONEY_WITH_REMAINDER;

public class PurchasePrice {
    private static final int CENT = 100;
    private static final long LOTTO_PRICE = 1000L;
    private static final double DECIMAL_PLACES = 10.0;

    private final long amount;

    private PurchasePrice(long amount) {
        validateIsMoneyMoreThanZero(amount);
        validateDividedByDivisorWithoutRemainder(amount);
        this.amount = amount;
    }

    public static PurchasePrice createPurchase(long amount) {
        return new PurchasePrice(amount);
    }

    private void validateIsMoneyMoreThanZero(long amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException(MONEY_LESS_THAN_ZERO.toString());
        }
    }

    private void validateDividedByDivisorWithoutRemainder(long amount) {
        if (amount % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException(MONEY_WITH_REMAINDER.toString());
        }
    }

    public long getLottoCount() {
        return amount / LOTTO_PRICE;
    }

    public double calculateRateOfReturn(final long prizeSum) {
        double result = ((double) prizeSum / amount) * CENT;
        return Math.round(result * DECIMAL_PLACES) / DECIMAL_PLACES;
    }
}
