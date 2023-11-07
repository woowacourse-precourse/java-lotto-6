package lotto.validator;

import lotto.config.Config;
import lotto.view.ErrorMessage;

public class PurchaseValidator {
    public static void validateIntegerInput(String purchaseAmount) {
        try {
            Integer.parseInt(purchaseAmount);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.INPUT_IS_NOT_DIGIT);
        }
    }

    public static void validateIsDivisible(int purchaseAmount) {
        if (purchaseAmount % Config.LOTTO_PRICE != Config.ZERO) {
            throw new IllegalArgumentException(ErrorMessage.INPUT_IS_NOT_DIVIDE);
        }
    }
}
