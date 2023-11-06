package lotto.util;

import lotto.model.LottoMoneyValidator;

public class Utils {
    private static final String NULL_ERROR_MESSAGE = "[ERROR] 입력값이 null 일 수 없습니다.";
    private static final String BLANK_ERROR_MESSAGE = "[ERROR] 입력값은 빈 값일 수 없습니다.";
    private static final String NUMBER_ERROR_MESSAGE = "[ERROR] 입력값은 숫자여야 합니다.";

    public static int parseInt(String input) {
        validateStringIsNumber(input);
        return Integer.parseInt(input);
    }

    public static int validateStringIsNumber(String input) {
        validateHasInput(input);
        for (int i = 0; i < input.length(); i++) {
            if (!Character.isDigit(input.charAt(i))) {
                throw new IllegalArgumentException(NUMBER_ERROR_MESSAGE);
            }
        }
        return Utils.parseInt(input);
    }

    public static void validateHasInput(String input) {
        if (input == null) {
            throw new IllegalArgumentException(NULL_ERROR_MESSAGE);
        }

        if (input.isBlank()) { // "", " " : true
            throw new IllegalArgumentException(BLANK_ERROR_MESSAGE);
        }
    }
}
