package lotto.validator;

public class PurchaseAmountValidator {
    public static int parseAndValidatePurchaseAmount(String input) {
        int amount = validateNumericInput(input);
        validateAmountUnit(amount);
        return amount;
    }

    private static int validateNumericInput(String input) {
        if (!input.matches("\\d+")) {
            throw new IllegalArgumentException("[ERROR] 올바른 금액을 입력해 주세요.");
        }
        int parsedAmount = Integer.parseInt(input);
        if (parsedAmount <= 1000) {
            throw new IllegalArgumentException("[ERROR] 최소 구입 금액은 1000원입니다.");
        }
        return parsedAmount;
    }

    private static void validateAmountUnit(int amount) {
        if (amount % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1,000원 단위로 입력 받으며 1,000원으로 나누어 떨어져야 합니다.");
        }
    }
}
