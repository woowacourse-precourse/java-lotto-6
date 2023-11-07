package lotto.utils;

import lotto.enums.ErrorMessage;

public class InputValidator {
    private static final int LESS_AMOUNT = 1000;

    public static void checkLottoPayAmountInput(String lottoPayAmount) {
        checkNumeric(lottoPayAmount);
        checkLessAmount(lottoPayAmount);
        checkLessAmountUnit(lottoPayAmount);
    }

    private static void checkLessAmountUnit(String lottoPayAmount) {
        if (Integer.parseInt(lottoPayAmount) % LESS_AMOUNT != 0) {
            throw new IllegalArgumentException(ErrorMessage.LESS_AMOUNT_UNIT_ERROR.getErrorMessage());
        }
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

    public static void checkJackpotNumberInput(String jackpotNumberInput) {
        // TODO : 쉼표(,)가 없는 경우
        checkHasComma(jackpotNumberInput);
        // TODO : 숫자를 입력하지 않았을 경우
        // TODO : 숫자가 6개가 아닐 경우
        // TODO : 중복된 숫자를 입력했을 경우

    }

    private static void checkHasComma(String jackpotNumberInput) {
        if (!jackpotNumberInput.contains(",")) {
            throw new IllegalArgumentException(ErrorMessage.HAS_NOT_COMMA_ERROR.getErrorMessage());
        }
    }
}
