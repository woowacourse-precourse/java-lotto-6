package lotto.validator;

import static lotto.util.Constants.LOTTO_PRICE;

public class PurchaseAmountValidator {
    public static int parseAndValidatePurchaseAmount(String input) {
        int parsedAmount = validateNumericInput(input);
        validateMinimumAmount(parsedAmount);
        validateAmountUnit(parsedAmount);
        return parsedAmount;
    }

    private static int validateNumericInput(String input) {
        if (!isNumeric(input)) {
            throw new IllegalArgumentException("[ERROR] 올바른 금액을 입력해 주세요.");
        }
        return Integer.parseInt(input);
    }

    private static boolean isNumeric(String input) {
        return input.matches("\\d+");
    }

    private static void validateMinimumAmount(int amount) {
        if (amount < LOTTO_PRICE) {
            throw new IllegalArgumentException("[ERROR] 최소 구입 금액은 1,000원입니다.");
        }
    }

    private static void validateAmountUnit(int amount) {
        if (amount % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1,000원 단위로 입력 받으며 1,000원으로 나누어 떨어져야 합니다.");
        }
    }
}
