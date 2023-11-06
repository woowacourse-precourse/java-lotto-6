package lotto.model.domain;

import static lotto.util.Constants.PURCHASE_PRICE_UNIT;
import static lotto.util.ExceptionMessage.PURCHASE_INVALID_TYPE;
import static lotto.util.ExceptionMessage.PURCHASE_INVALID_UNIT;

public class PurchaseValidator {

    public int validateIntegerInput(String price) {
        try {
            return Integer.parseInt(price);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(PURCHASE_INVALID_TYPE.getMessage());
        }
    }

    public int validatePriceInThousandUnit(int price) {
        if(price % PURCHASE_PRICE_UNIT != 0) {
            throw new IllegalArgumentException(PURCHASE_INVALID_UNIT.format(PURCHASE_PRICE_UNIT));
        }
        return price/PURCHASE_PRICE_UNIT;
    }

}
