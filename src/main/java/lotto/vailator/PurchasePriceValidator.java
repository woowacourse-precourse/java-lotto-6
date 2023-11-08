package lotto.vailator;

import static lotto.util.ErrorMessage.MIN_PURCHASE_PRICE_ERROR;
import static lotto.util.ErrorMessage.PURCHASE_PRICE_REMAINDER_NOT_ZERO;
import static lotto.util.LottoNumber.PURCHASE_MIN_PRICE;

public class PurchasePriceValidator {
    private boolean isUnderMinPrice(int price) {
        return price < PURCHASE_MIN_PRICE.getValue();
    }

    public void checkOverMinPrice(int price) {
        if (isUnderMinPrice(price)) {
            throw new IllegalArgumentException(MIN_PURCHASE_PRICE_ERROR.getErrorMessage());
        }
    }

    private boolean isRemainderNotZero(int price) {
        return price % PURCHASE_MIN_PRICE.getValue() != 0;
    }

    public void checkRemainderZero(int price) {
        if (isRemainderNotZero(price)) {
            throw new IllegalArgumentException(PURCHASE_PRICE_REMAINDER_NOT_ZERO.getErrorMessage());
        }
    }
}
