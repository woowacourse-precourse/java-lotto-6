package lotto.Domain;

import lotto.Constant.Constant;

public class Money {

    private final Integer value;

    public Money(String value) {
        validate(value);
        this.value = Integer.parseInt(value);
    }

    public Integer getValue() {
        return value;
    }

    private void validate(String value) {
        isNumber(value);
        isDivide(value);
    }

    //숫자값인지 확인
    private void isNumber(String value) {
        if (!value.matches(Constant.NUMBER_PATTERN)) {
            throw new IllegalArgumentException(
                    Constant.ERROR_PREFIX + Constant.NUMBER_PREFIX + Constant.ERROR_NOT_NUMBER_MESSAGE);
        }
    }

    //1,000으로 나누어지는지 확인
    private void isDivide(String value) {
        if (Integer.parseInt(value) % Constant.LOTTO_DIVIDE_PRICE != 0) {
            throw new IllegalArgumentException(
                    Constant.ERROR_PREFIX + Constant.NUMBER_PREFIX + Constant.ERROR_NOT_DIVIDE_MESSAGE);
        }
    }
}
