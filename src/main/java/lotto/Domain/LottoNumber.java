package lotto.Domain;

import lotto.Constant.Constant;

public class LottoNumber {
    private Integer number;

    public LottoNumber(String number) {
        validate(number);
        this.number = Integer.parseInt(number);
    }

    public Integer getNumber() {
        return number;
    }

    private void validate(String number) {
        isEmpty(number);
        isNumber(number);
        isBoundary(number);
    }

    //숫자인지 확인
    private void isNumber(String number) {
        if (!number.matches(Constant.NUMBER_PATTERN)) {
            throw new IllegalArgumentException(
                    Constant.ERROR_PREFIX + Constant.USER_NUMBER_PREFIX + Constant.ERROR_NOT_NUMBER_MESSAGE);
        }
    }

    //빈칸인지 확인
    private void isEmpty(String number) {
        if (number.equals("")) {
            throw new IllegalArgumentException(
                    Constant.ERROR_PREFIX + Constant.USER_NUMBER_PREFIX + Constant.ERROR_EMPTY_MESSAGE);
        }
    }

    //1~45 사이의 숫자인지 확인
    private void isBoundary(String number) {
        if (Integer.parseInt(number) < Constant.LOTTO_MIN_NUMBER
                || Integer.parseInt(number) > Constant.LOTTO_MAX_NUMBER) {
            throw new IllegalArgumentException(
                    Constant.ERROR_PREFIX + Constant.USER_NUMBER_PREFIX + Constant.ERROR_NOT_BOUNDARY_MESSAGE);
        }
    }
}
