package lotto.domain;

import java.util.Objects;

public class Money {

    private static final String INVALID_INPUT_MESSAGE = "음수의 숫자를 받을 수 없습니다.";
    private final long value;

    public Money(long value) {
        if(value < 0) {
            throw new IllegalArgumentException(INVALID_INPUT_MESSAGE);
        }
        this.value = value;
    }

    public boolean isDivisible(long divisor) {
        if(this.value == 0) return false;
        return this.value % divisor == 0;
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
}
