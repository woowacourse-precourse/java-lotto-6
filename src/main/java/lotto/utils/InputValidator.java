package lotto.utils;

import lotto.enums.ErrorMessage;

public class InputValidator {
    public static void checkLottoPayAmountInput(String lottoPayAmount) {
        checkNumeric(lottoPayAmount);
        // TODO : 0원인지 체크
        // TODO : 1000원 단위 체크
    }

    private static void checkNumeric(String lottoPayAmount) {
        for (int i = 0; i < lottoPayAmount.length(); i++) {
            if (!Character.isDigit(lottoPayAmount.charAt(i))) {
                throw new IllegalArgumentException(ErrorMessage.NUMERIC_ERROR.getErrorMessage());
            }
        }
    }
}
