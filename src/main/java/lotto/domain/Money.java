package lotto.domain;

import lotto.constraints.ErrorMessage;

import java.math.BigDecimal;
import java.math.RoundingMode;

import static lotto.domain.NumberConstraints.LOTTO_PER_PRICE;

public record Money(
        int money
) {
    public static Money of(int input) {
        validateLessThanPerPrice(input);
        validateMultipleOfPerPrice(input);
        return new Money(input);
    }

    private static void validateLessThanPerPrice(int input) {
        if (input < LOTTO_PER_PRICE.value()) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_MONEY.getMessage());
        }
    }

    private static void validateMultipleOfPerPrice(int input) {
        if (input % LOTTO_PER_PRICE.value() != 0) {
            throw new IllegalArgumentException(ErrorMessage.NOT_MULTIPLE_PER_PRICE.getMessage());
        }
    }

    public int calculateNumberOfLotto() {
        return money / LOTTO_PER_PRICE.value();
    }

    public double calculateProfitRate(long totalPrizeMoney) {
        double profitRate = ((double) totalPrizeMoney / this.money) * 100 - 100;
        return new BigDecimal(profitRate).setScale(2, RoundingMode.HALF_UP).doubleValue();
    }
}
