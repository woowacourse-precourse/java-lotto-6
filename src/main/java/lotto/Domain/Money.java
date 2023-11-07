package lotto.Domain;

import lotto.Constant.Constant;

public class Money {

    private final Integer value;
    private final Integer count;

    public Money(String value) {
        validate(value);
        this.value = Integer.parseInt(value);
        this.count = makeCount(this.value);
    }

    public Integer getValue() {
        return value;
    }

    public Integer getCount() {
        return count;
    }

    private int makeCount(int value) {
        return value / Constant.LOTTO_DIVIDE_PRICE;
    }

    private void validate(String value) {
        isEmpty(value);
        isNumber(value);
        isBigger(value);
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

    //빈칸인지 확인
    private void isEmpty(String value) {
        if (value.equals("")) {
            throw new IllegalArgumentException(
                    Constant.ERROR_PREFIX + Constant.NUMBER_PREFIX + Constant.ERROR_EMPTY_MESSAGE
            );
        }
    }

    //1,000이상인지 확인
    private void isBigger(String value) {
        if (Integer.parseInt(value) < Constant.LOTTO_DIVIDE_PRICE) {
            throw new IllegalArgumentException(
                    Constant.ERROR_PREFIX + Constant.NUMBER_PREFIX + Constant.ERROR_NOT_BIGGER_MESSAGE
            );
        }
    }
}
