package lotto.validators;

import static lotto.constant.ErrorMessage.INPUT_PRICE_IS_NOT_GREATER_THAN_ZERO;
import static lotto.constant.ErrorMessage.INPUT_PRICE_IS_NOT_MULTIPLE_OF_LOTTO_PRICE;
import static lotto.constant.LottoInfo.LOTTO_PRICE;

public class PurchaseValidator {
    public static void validPurchasePrice(Integer purchasePrice) {
        if (!isMultipleOfLottoPrice(purchasePrice)) {
            throw new IllegalArgumentException(INPUT_PRICE_IS_NOT_MULTIPLE_OF_LOTTO_PRICE);
        }
        if (!isGreaterThanZero(purchasePrice)) {
            throw new IllegalArgumentException(INPUT_PRICE_IS_NOT_GREATER_THAN_ZERO);
        }
    }

    private static boolean isMultipleOfLottoPrice(Integer purchasePrice) {
        return purchasePrice % LOTTO_PRICE == 0;
    }

    private static boolean isGreaterThanZero(Integer purchasePrice) {
        return purchasePrice > 0;
    }
}
