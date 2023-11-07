package lotto.Domain;

import lotto.Constant.Constant;

public class Money {

    private final int value;

    public Money(String value) {
        validate(value);
        this.value = Integer.parseInt(value);
    }

    private void validate(String value) {
        isNumber(value);
    }

    //숫자값인지 확인
    private void isNumber(String value) {
        if(!value.matches(Constant.NUMBER_PATTERN)) {
            throw new IllegalArgumentException(Constant.ERROR_PREFIX + Constant.ERROR_NOT_NUMBER_MESSAGE);
        }
    }


}
