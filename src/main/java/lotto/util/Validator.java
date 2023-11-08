package lotto.util;

import java.util.regex.Pattern;

public class Validator {
    private static final Pattern INPUT_PATTERN = Pattern.compile("^[\\d]+,[\\d]+,[\\d]+,[\\d]+,[\\d]+,[\\d]+$");
    private static final String INVALID_MONEY_TYPE = "[ERROR] 금액은 숫자여야 합니다.";
    private static final String MONEY_MUST_NOT_NEGATIVE = "[ERROR] 금액은 음수일 수 없습니다.";
    private static final String INVALID_INPUT_PATTERN = "[ERROR] 입력 형식과 맞지 않습니다.";

    public static void validateMoney(String money) {
        validateMoneyType(money);
        validateMoneyRange(money);
    }

    public static void validateMoneyType(String money) {
        try {
            Integer.parseInt(money);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INVALID_MONEY_TYPE);
        }
    }

    public static void validateMoneyRange(String money) {
        int amount = Integer.parseInt(money);

        if (amount < 0) {
            throw new IllegalArgumentException(MONEY_MUST_NOT_NEGATIVE);
        }
    }

    public static void validateInputPattern(String winningLotto) {
        if (!INPUT_PATTERN.matcher(winningLotto).matches()) {
            throw new IllegalArgumentException(INVALID_INPUT_PATTERN);
        }
    }
}
