package lotto.model;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Money {

    private static final String MONEY_UNIT_EXCEPTION_MESSAGE = "[ERROR] 입력 금액은 1000원 단위여야 합니다.";
    private static final String NEGATIVE_AMOUNT_EXCEPTION_MESSAGE = "[ERROR] 입력 금액은 음수이면 안 됩니다.";
    private static final int DEFAULT_SCALE = 4;

    private final long money;

    public Money(final long money) {
        validateMultipleOfThousand(money);
        validateNonNegativeAmount(money);
        this.money = money;
    }

    public Money multiply(final int winningCount) {
        return new Money(money * winningCount);
    }

    public BigDecimal divide(final Money another) {
        return BigDecimal.valueOf(money)
                .divide(BigDecimal.valueOf(another.getMoney()), DEFAULT_SCALE, RoundingMode.HALF_UP);
    }

    public int getNumberOfLotto() {
        return (int) (money / LottoConstants.LOTTO_PRICE_UNIT);
    }

    public long getMoney() {
        return money;
    }

    private void validateMultipleOfThousand(final long money) {
        if (isNotMultipleOfUnit(money)) {
            throw new IllegalArgumentException(MONEY_UNIT_EXCEPTION_MESSAGE);
        }
    }

    private boolean isNotMultipleOfUnit(final long money) {
        return money % LottoConstants.LOTTO_PRICE_UNIT != 0L;
    }

    private void validateNonNegativeAmount(final long money) {
        if (money < 0L) {
            throw new IllegalArgumentException(NEGATIVE_AMOUNT_EXCEPTION_MESSAGE);
        }
    }
}
