package lotto.validator;

public class MoneyValidator {
    private static final int MIN_MONEY = 1000;
    private static final int MAX_MONEY = 100000;
    private static final int MONEY_UNIT = 1000;
    private static final String ERROR = "[ERROR] 돈은 ";
    private static final String ERROR_BLANK = ERROR + "공백을 허용하지 않습니다.";
    private static final String ERROR_STRING = ERROR + "정수만 입력할 수 있습니다.";
    private static final String ERROR_MIN_MAX = ERROR + "최소 " + MIN_MONEY + "원, " + "최대 " + MAX_MONEY + "원 입니다.";
    private static final String ERROR_MONEY_UNIT = ERROR + MONEY_UNIT + "원 단위 입니다.";

    private MoneyValidator() {}

    public static void validate(final String input) {
        validateMoneyBlankException(input);
        validateMoneyNumberFormatException(input);
        validateMoneyMaxRange(input);
        validateMoneyThousandUnit(input);
    }

    private static void validateMoneyBlankException(final String input) {
        if (input == null || input.isBlank()) {
            throw new IllegalArgumentException(ERROR_BLANK);
        }
    }

    private static void validateMoneyNumberFormatException(final String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ERROR_STRING);
        }
    }

    private static void validateMoneyMaxRange(final String input) {
        if (Integer.parseInt(input) > MAX_MONEY || Integer.parseInt(input) < MIN_MONEY) {
            throw new IllegalArgumentException(ERROR_MIN_MAX);
        }
    }

    private static void validateMoneyThousandUnit(final String input) {
        if (Integer.parseInt(input) % MONEY_UNIT != 0) {
            throw new IllegalArgumentException(ERROR_MONEY_UNIT);
        }
    }
}
