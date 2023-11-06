package lotto.validator;

import java.util.regex.Pattern;

public class MoneyValidator {
    private static final String ERROR_STRING = "[ERROR] 금액에 숫자가 아닌 문자가 올 수 없습니다.";
    private static final String ERROR_DIVIDE = "[ERROR] 금액은 1000으로 나누어지는 수여야 합니다.";
    private static final String ERROR_ZERO = "[ERROR] 금액은 0보다 큰 수입니다.";
    private static final Pattern PATTERN = Pattern.compile("\\d+");
    private static final int ZERO = 0;
    private static final int THOUSAND = 1000;

    public static void validateMoney(int inputValue) {
        validateZero(inputValue);
        validateDivideMoney(inputValue);
    }

    private static void validateZero(int inputValue) {
        if (inputValue == ZERO) {
            throw new IllegalArgumentException(ERROR_ZERO);
        }
    }

    private static void validateDivideMoney(int inputValue) {
        if (inputValue % THOUSAND != ZERO) {
            throw new IllegalArgumentException(ERROR_DIVIDE);
        }
    }

    public static void validateMoneyFormat(String input) {
        if (!PATTERN.matcher(input).matches()) {
            throw new IllegalArgumentException(ERROR_STRING);
        }
    }
}
