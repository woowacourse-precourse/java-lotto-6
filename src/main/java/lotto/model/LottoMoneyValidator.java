package lotto.model;

import lotto.util.Utils;

public class LottoMoneyValidator {
    private static final String NULL_ERROR_MESSAGE = "[ERROR] 입력값이 null 일 수 없습니다.";
    private static final String BLANK_ERROR_MESSAGE = "[ERROR] 입력값은 빈 값일 수 없습니다.";
    private static final String NUMBER_ERROR_MESSAGE = "[ERROR] 입력값은 숫자여야 합니다.";
    private static final String MONEY_NEGATIVE_ERROR_MESSAGE = "[ERROR] 구입 금액은 양수여야 합니다.";
    private static final String MONEY_FORMAT_ERROR_MESSAGE = "[ERROR] 구입 금액은 1000 단위로 받습니다.";

    public static void validateMoneyIsValid(String input) {
        validateMoneyIsPositive(input);
        validateMoneyDivideBy1000(input);
    }

    public static void validateMoneyIsPositive(String input) {
        int number = Utils.parseInt(input);
        if (number <= 0) {
            throw new IllegalArgumentException(MONEY_NEGATIVE_ERROR_MESSAGE);
        }
    }

    public static void validateMoneyDivideBy1000(String input) {
        int number = Utils.parseInt(input);
        if (number % 1000 != 0) {
            throw new IllegalArgumentException(MONEY_FORMAT_ERROR_MESSAGE);
        }

    }

    public static void validateInputString(String input) {
        validateHasInput(input);
        for (int i = 0; i < input.length(); i++) {
            if (!Character.isDigit(input.charAt(i))) {
                throw new IllegalArgumentException(NUMBER_ERROR_MESSAGE);
            }
        }
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