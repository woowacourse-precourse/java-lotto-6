package lotto.validation;

public class AmountValidator {

    public static int validateAmount(String amountStr) {
        int amount = parseToInt(amountStr);
        validateMinimumAmount(amount);
        validateThousandUnit(amount);
        return amount;
    }

    private static int parseToInt(String amount) {
        try {
            return Integer.parseInt(amount);
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException("[ERROR] 정수형 숫자만 입력할 수 있습니다.");
        }
    }

    private static void validateMinimumAmount(int amount) {
        if (amount < 1000) {
            throw new IllegalArgumentException("[ERROR] 구매 금액은 최소 1000원 입니다.");
        }
    }

    private static void validateThousandUnit(int amount) {
        if (amount % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 구매 금액은 1000원 단위로 입력해야 합니다.");
        }
    }
}
