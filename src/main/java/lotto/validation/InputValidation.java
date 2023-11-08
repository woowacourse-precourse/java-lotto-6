package lotto.validation;

public class InputValidation {

    public static void validatePurchaseAmount(int amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("[ERROR]구매 금액은 0보다 커야 합니다.");
        }
    }

    public static void validatePurchaseThousand(int amount) {
        if (amount % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR]구매 금액은 1000원 단위여야 합니다.");
        }
    }
}
