package lotto.validation;

public class InputValidation {

    private static final String ERROR = "[ERROR] ";
    private static final String IS_NULL_MESSAGE = "빈 문자열 입니다";
    private static final String IS_NOT_NUMBER_MESSAGE = "숫자가 아닙니다";
    private static final String IS_EXCEED_NUMBER_RANGE_MESSAGE = "21억을 초과했습니다.";
    private static final String IS_NOT_NUMBER_Range_MESSAGE = "0이하 입니다";
    private static final int MONEY_UNIT = 1000;
    private static final String IS_NOT_MONEY_UNIT_MESSAGE = MONEY_UNIT + "원 단위가 아닙니다";

    public void validationMoney(String input) {
        isEmptyValidation(input);
        isNumberValidation(input);
        changeInteger(input);
        isNumberRangeValidation(input);
        isMoneyUnitValidation(input);
    }

    public void validationLottoWinningNumber(String lottoNumbers) {
        isEmptyValidation(lottoNumbers);
    }

    private void isEmptyValidation(String input) {
        if (input.isBlank()) {
            throw new IllegalArgumentException(ERROR + IS_NULL_MESSAGE);
        }
    }

    private void isNumberValidation(String input) {
        for (int i = 0; i < input.length(); i++) {
            if (!Character.isDigit(input.charAt(i))) {
                throw new IllegalArgumentException(ERROR + IS_NOT_NUMBER_MESSAGE);
            }
        }
    }

    private void changeInteger(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ERROR + IS_EXCEED_NUMBER_RANGE_MESSAGE);
        }
    }

    private void isNumberRangeValidation(String input) {
        if (Integer.parseInt(input) <= 0) {
            throw new IllegalArgumentException(ERROR + IS_NOT_NUMBER_Range_MESSAGE);
        }
    }

    private void isMoneyUnitValidation(String input) {
        if (Integer.parseInt(input) % MONEY_UNIT != 0) {
            throw new IllegalArgumentException(ERROR + IS_NOT_MONEY_UNIT_MESSAGE);
        }
    }
}
