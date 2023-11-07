package lotto.validator;

import lotto.constant.ErrorMessage;

import static lotto.constant.LottoConstant.LOTTO_MONEY_UNIT;

public class Validation {

    public static void checkEnter(String money){
        if(money.length() == 0){
            throw new IllegalArgumentException(ErrorMessage.NON_EXIST_INPUT.getMessage());
        }
    }

    public static void checkDigit(String money) {
        for (char ch : money.toCharArray()) {
            if (!Character.isDigit(ch)) {
                throw new IllegalArgumentException(ErrorMessage.NOT_DIGIT.getMessage());
            }
        }
    }

    public static void checkZero(String money) {
        if (Integer.parseInt(money) == 0) {
            throw new IllegalArgumentException(ErrorMessage.EXIST_ZERO.getMessage());
        }
    }

    public static void checkAvailableDivide(String money) {
        if (Integer.parseInt(money) % LOTTO_MONEY_UNIT != 0) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_MONEY.getMessage());
        }
    }

}
