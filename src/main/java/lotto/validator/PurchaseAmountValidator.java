package lotto.validator;

import static java.lang.Integer.parseInt;
import static lotto.config.LottoConfig.PRICE;
import static lotto.view.message.ErrorMessage.NOT_PRICE_UNITS;

public class PurchaseAmountValidator {
    public static void validate(String purchaseAmount) {
        InputValidator.validateEmpty(purchaseAmount);
        InputValidator.validateDigit(purchaseAmount);
        validatePrice(purchaseAmount);
    }

    private static void validatePrice(String purchaseAmount) {
        if (parseInt(purchaseAmount) % PRICE.getNumber() != 0) {
            throw new IllegalArgumentException(NOT_PRICE_UNITS.getErrorMessage());
        }
    }
}
