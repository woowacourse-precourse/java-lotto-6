package lotto.util;

import static lotto.util.Utils.parseInt;

public class Validator {
    private static final String MONEY_NEGATIVE_ERROR_MESSAGE = "[ERROR] 구입 금액은 양수여야 합니다.";
    private static final String MONEY_FORMAT_ERROR_MESSAGE = "[ERROR] 구입 금액은 1000 단위로 받습니다.";

    public static String validateLottoNumber(String input) {
        return "";
    }

    public static int validateBonusNumber(String input) {
        return parseInt(input);
    }

    public static int validateMoneyIsValid(String input) {
        int number = parseInt(input);
        validateMoneyIsPositive(number);
        validateMoneyDivideBy1000(number);
        return number/1000;
    }

    public static void validateMoneyIsPositive(int number) {
        if (number <= 0) {
            throw new IllegalArgumentException(MONEY_NEGATIVE_ERROR_MESSAGE);
        }
    }

    public static void validateMoneyDivideBy1000(int number) {
        if (number % 1000 != 0) {
            throw new IllegalArgumentException(MONEY_FORMAT_ERROR_MESSAGE);
        }
    }
}