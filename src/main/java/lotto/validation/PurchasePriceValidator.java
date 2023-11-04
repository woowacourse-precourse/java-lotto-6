package lotto.validation;

import static lotto.constant.ValidateMessage.PURCHASE_PRICE_CANNOT_BE_NULL_OR_EMPTY;
import static lotto.constant.ValidateMessage.PURCHASE_PRICE_IS_NOT_INTEGER;

public class PurchasePriceValidator {

    public void isNullOrEmpty(String purchasePrice) {
        if (purchasePrice == null || purchasePrice.length() == 0) {
            PURCHASE_PRICE_CANNOT_BE_NULL_OR_EMPTY.throwException();
        }
    }

    public int isInteger(String purchasePrice) {
        if (!isNumeric(purchasePrice)) {
            PURCHASE_PRICE_IS_NOT_INTEGER.throwException();
        }
        return Integer.parseInt(purchasePrice);
    }

    private boolean isNumeric(String purchasePrice) {
        try {
            Integer.parseInt(purchasePrice);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
