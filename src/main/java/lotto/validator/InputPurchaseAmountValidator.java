package lotto.validator;

public class InputPurchaseAmountValidator {
    public static void validatePurchaseAmount(String purchaseAmount) {
        validateOnlyNumberAmount(purchaseAmount);
        int purchasedAmount = Integer.parseInt(purchaseAmount);
        validateZeroAmount(purchasedAmount);
        validate1000UnitAmount(purchasedAmount);
    }

    private static void validateOnlyNumberAmount(String purchaseAmount) {
        if (!purchaseAmount.matches("\\d+")) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 숫자로만 입력되어야 합니다.");
        }
    }

    private static void validateZeroAmount(int purchasedAmount) {
        if (purchasedAmount < 1000) {
            throw new IllegalArgumentException("[ERROR] 구액 금액은 최소 1000원입니다.");
        }
    }

    private static void validate1000UnitAmount(int purchasedAmount) {
        if (purchasedAmount % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1,000원 단위여야 합니다.");
        }
    }
}
