package lotto.domain;

import java.text.DecimalFormat;
import java.util.Objects;

public class Money {

    private static final String NOT_DIVIDED_ERROR_MESSAGE = "나누어 떨어지지 않는 숫자입니다.";
    private static final String INVALID_INPUT_MESSAGE = "음수의 숫자를 받을 수 없습니다.";
    private static final String CURRENCY_UNIT = "원";
    private static final int ZERO_VALUE = 0;

    private final long value;

    public Money(long value) {
        validate(value);
        this.value = value;
    }

    public Money plus(Money otherMoney) {
        return new Money(this.value + otherMoney.value);
    }

    public Money multiply(Integer count) {
        return new Money(this.value * count);
    }

    public int quantityAvailableForPurchase(int lottoUnitPrice) {
        if (isDivisible(lottoUnitPrice)) {
            return (int) (this.value / lottoUnitPrice);
        }

        throw new IllegalArgumentException(NOT_DIVIDED_ERROR_MESSAGE);
    }

    public boolean isDivisible(long divisor) {
        if (isZero()) return false;
        return this.value % divisor == ZERO_VALUE;
    }

    public long getValue() {
        return this.value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Money money = (Money) o;
        return Objects.equals(value, money.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        DecimalFormat decFormat = new DecimalFormat("###,###");
        return decFormat.format(this.value) + CURRENCY_UNIT;
    }

    private void validate(long value) {
        if (value < ZERO_VALUE) {
            throw new IllegalArgumentException(INVALID_INPUT_MESSAGE);
        }
    }

    private boolean isZero() {
        return this.value == ZERO_VALUE;
    }
}
