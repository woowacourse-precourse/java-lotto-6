package lotto.utils;

import lotto.enums.ErrorMessage;

public class InputValidator {
    private static final int LESS_AMOUNT = 1000;

    public static void checkLottoPayAmountInput(String lottoPayAmount) {
        checkNumeric(lottoPayAmount);
        checkLessAmount(lottoPayAmount);
        // TODO : 1000원 단위 체크
    }

    private static void checkLessAmount(String lottoPayAmount) {
        if (Integer.parseInt(lottoPayAmount) < LESS_AMOUNT) {
            throw new IllegalArgumentException(ErrorMessage.LESS_AMOUNT_ERROR.getErrorMessage());
        }
    }

    private static void checkNumeric(String lottoPayAmount) {
        for (int i = 0; i < lottoPayAmount.length(); i++) {
            if (!Character.isDigit(lottoPayAmount.charAt(i))) {
                throw new IllegalArgumentException(ErrorMessage.NUMERIC_ERROR.getErrorMessage());
            }
        }
    }
}
