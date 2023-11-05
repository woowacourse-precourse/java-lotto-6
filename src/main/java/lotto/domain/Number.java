package lotto.domain;

public class Number implements Comparable<Number> {

    static final int MIN_VALUE = 1;
    static final int MAX_VALUE = 45;

    private final int value;

    private Number(int value) {
        validate(value);
        this.value = value;
    }

    private void validate(int value) {
        if (isOutOfRange(value)) {
            String exceptionMessage = "로또 숫자는 %d 이상 %d 이하이어야 합니다".formatted(MIN_VALUE, MAX_VALUE);
            throw new IllegalArgumentException(exceptionMessage);
        }
    }

    private boolean isOutOfRange(int value) {
        return value < MIN_VALUE || value > MAX_VALUE;
    }

    public static Number from(int value) {
        return new Number(value);
    }

    public int getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Number number = (Number) o;
        return value == number.value;
    }

    @Override
    public int hashCode() {
        return value;
    }

    @Override
    public String toString() {
        return "Number{value=%d}".formatted(value);
    }

    @Override
    public int compareTo(Number o) {
        return Integer.compare(this.value, o.value);
    }
}
