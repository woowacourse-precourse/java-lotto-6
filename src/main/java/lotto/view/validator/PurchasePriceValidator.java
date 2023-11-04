package lotto.view.validator;

import static lotto.config.GameNumberConfig.LOTTO_PRICE;
import static lotto.exception.ErrorMessage.VALIDATE_PURCHASE_PRICE_DIVIDE;

import lotto.view.OutputView;

public class PurchasePriceValidator {
    public static boolean validatePurchasePrice(String inputPurchasePrice) {
        try {
            InputNumberValidator.checkEmpty(inputPurchasePrice);
            InputNumberValidator.checkNumber(inputPurchasePrice);
            checkDivide(inputPurchasePrice);
            return true;
        } catch (IllegalArgumentException e) {
            OutputView.printMessage(e.getMessage());
            return false;
        }
    }

    private static void checkDivide(String inputPurchasePrice) {
        int purchasePrice = Integer.parseInt(inputPurchasePrice);
        if (purchasePrice % LOTTO_PRICE.getNumber() != 0) {
            throw new IllegalArgumentException(VALIDATE_PURCHASE_PRICE_DIVIDE.getMessage());
        }
    }
}
