package lotto.domain.lotto;


import lotto.exception.NumberNullException;

public class Number {
    private final Integer value;

    public Number(Integer value) {
        this.value = value;
    }

    public Integer getValue() {
        validateNotNullNumber();
        return value;
    }

    private void validateNotNullNumber() {
        if (value == null) {
            throw new NumberNullException();
        }
    }
}
