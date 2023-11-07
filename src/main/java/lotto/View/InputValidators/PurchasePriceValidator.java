package lotto.View.InputValidators;

import lotto.Model.Enums.ErrorMessages;

public class PurchasePriceValidator extends InputValidator{
    private int validatedPurchasePrice;
    public PurchasePriceValidator() throws IllegalArgumentException{
        validatePurchasePrice(super.userInput);
    }
    public int returnValidatedPrice(){
        return validatedPurchasePrice;
    }
    private void validatePurchasePrice(String userInputPurchasePrice) throws IllegalArgumentException {
        int purchasePrice;
        try {
            purchasePrice = validateStringIsInt(userInputPurchasePrice);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(ErrorMessages.PURCHASE_PRICE_FORM.getString());
        }
        if (purchasePrice < 1000) {
            throw new IllegalArgumentException(ErrorMessages.PURCHASE_PRICE_MINIMUM.getString());
        }
        if (purchasePrice % 1000 != 0) {
            throw new IllegalArgumentException(ErrorMessages.PURCHASE_PRICE_FORM.getString());
        }
        validatedPurchasePrice = purchasePrice;
    }
}
