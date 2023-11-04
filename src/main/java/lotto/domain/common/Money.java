package lotto.domain.common;

import java.util.Objects;

public class Money {

    private static final int NON_POSITIVE_STANDARD = 0;
    private static final String NON_POSITIVE_MONEY_MESSAGE = "돈은 양수여야 합니다.";
    private static final String UNKNOWN_MONEY_MESSAGE = "알 수 없는 돈과 해당 연산을 수행할 수 없습니다.";
    public static final String CURRENCY = "원";

    private final double value;

    private Money(double value) {
        this.value = value;
    }

    public static Money from(double value) {
        checkPositiveMoney(value);

        return new Money(value);
    }

    private static void checkPositiveMoney(double value) {
        if (isNonPositive(value)) {
            throw new IllegalArgumentException(NON_POSITIVE_MONEY_MESSAGE);
        }
    }

    private static boolean isNonPositive(double value) {
        return value <= NON_POSITIVE_STANDARD;
    }

    public double divide(Money target) {
        checkMoneyNonNull(target);

        return this.value / target.value;
    }

    public boolean hasRemainderWith(Money target) {
        checkMoneyNonNull(target);

        return (this.value % target.value) != 0;
    }

    private void checkMoneyNonNull(Money target) {
        if (Objects.isNull(target)) {
            throw new IllegalArgumentException(UNKNOWN_MONEY_MESSAGE);
        }
    }

    public double getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Money money = (Money) o;
        return Double.compare(money.value, value) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
