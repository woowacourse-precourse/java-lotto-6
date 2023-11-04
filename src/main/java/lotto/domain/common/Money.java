package lotto.domain.common;

import java.util.Objects;

public class Money {

    private static final int NON_POSITIVE_STANDARD = 0;
    private static final String NON_POSITIVE_MONEY_MESSAGE = "돈은 양수여야 합니다.";
    private static final String UNKNOWN_MONEY_MESSAGE = "알 수 없는 돈과 해당 연산을 수행할 수 없습니다.";

    private final int value;

    private Money(int value) {
        this.value = value;
    }

    public static Money from(int value) {
        checkPositiveMoney(value);

        return new Money(value);
    }

    private static void checkPositiveMoney(int value) {
        if (isNonPositive(value)) {
            throw new IllegalArgumentException(NON_POSITIVE_MONEY_MESSAGE);
        }
    }

    private static boolean isNonPositive(int value) {
        return value <= NON_POSITIVE_STANDARD;
    }

    public int divide(Money target) {
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

    public int getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Money money = (Money) o;
        return value == money.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
