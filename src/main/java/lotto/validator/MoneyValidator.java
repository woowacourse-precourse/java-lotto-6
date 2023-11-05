package lotto.validator;

import java.util.regex.Pattern;

public class MoneyValidator {
    private static final String ERROR_MESSAGE = "[ERROR] 구입금액을 입력해 주세요";
    private static final Pattern PATTERN = Pattern.compile("\\d+");
    private static final int ZERO = 0;
    private static final int THOUSAND = 1000;

    public static void validateMoney(int inputValue) {
        validateZero(inputValue);
        validateDivideMoney(inputValue);
    }

    private static void validateZero(int inputValue) {
        if (inputValue == ZERO) {
            throw new IllegalArgumentException();
        }
    }

    private static void validateDivideMoney(int inputValue) {
        if (inputValue % THOUSAND != ZERO) {
            throw new IllegalArgumentException();
        }
    }
    public static void validateMoneyFormat(String input) {
        if (!PATTERN.matcher(input).matches()) {
            throw new IllegalArgumentException(ERROR_MESSAGE);
        }
    }
}
