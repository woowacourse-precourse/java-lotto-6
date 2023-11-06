package lotto.domain;


import lotto.exception.NumberUpdateException;

public class Number {
    private final Integer value;

    public Number(Integer value) {
        this.value = value;
    }

    public Integer getValue() {
        validateUpdateNumber();
        return value;
    }

    private void validateUpdateNumber() {
        if (value == null) {
            throw new NumberUpdateException();
        }
    }
}
