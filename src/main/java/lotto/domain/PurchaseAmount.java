package lotto.domain;

import static lotto.common.exception.ExceptionMessages.INVALID_PURCHASE_AMOUNT;
import static lotto.common.exception.ExceptionMessages.NOT_DIVISIBLE_PURCHASE_AMOUNT;

import java.math.BigDecimal;
import java.math.RoundingMode;

public record PurchaseAmount(long amount) {
    public static final String PERCENT = "100";
    public static final int SCALE = 1;
    public static final int unit = 1000;

    public PurchaseAmount {
        validate(amount);
    }

    private void validate(long amount) {
        validateIsZero(amount);
        validateDivisible(amount);
    }

    private void validateIsZero(long amount) {
        if (amount == 0L) {
            throw new IllegalArgumentException(INVALID_PURCHASE_AMOUNT.getMessage());
        }
    }

    private void validateDivisible(long amount) {
        if (amount % unit != 0L) {
            throw new IllegalArgumentException(
                    String.format(NOT_DIVISIBLE_PURCHASE_AMOUNT.getMessage(), unit));
        }
    }

    public long getQuantity(int lottoPrice) {
        return amount / lottoPrice;
    }

    public BigDecimal getRateOfReturn(long totalPrize) {
        return new BigDecimal(totalPrize)
                .multiply(new BigDecimal(PERCENT))
                .divide(new BigDecimal(amount), SCALE, RoundingMode.HALF_UP);
    }
}
