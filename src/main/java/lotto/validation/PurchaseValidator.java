package lotto.validation;

public class PurchaseValidator {
    public static void validate(int amount) {
        validateIsInvalidAmount(amount);
        validateIsMoneyLeft(amount);
    }

    private static void validateIsInvalidAmount(int amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException(LottoException.AMOUNT_ERROR_MESSAGE.getMessage());
        }
    }

    private static void validateIsMoneyLeft(int amount) {
        if (amount % 1000 > 0) {
            throw new IllegalArgumentException(LottoException.MONEY_LEFT_ERROR_MESSAGE.getMessage());
        }
    }
}
