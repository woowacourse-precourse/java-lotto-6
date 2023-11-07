package lotto.View;

import lotto.View.InputValidators.PurchasePriceValidator;

public class InputUI {
    public static int inputPurchasePrice() throws IllegalArgumentException{
        // PurchasePriceValidator inherits InputValidator, so constructing it includes input process
        PurchasePriceValidator purchasePriceValidator = new PurchasePriceValidator();
        return purchasePriceValidator.returnValidatedPrice();
    }
}
