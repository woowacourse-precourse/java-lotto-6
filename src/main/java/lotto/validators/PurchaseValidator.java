package lotto.validators;

import static lotto.constant.LottoInfo.LOTTO_PRICE;

public class PurchaseValidator {
    private static boolean isMultipleOfLottoPrice(Integer purchasePrice) {
        return purchasePrice % LOTTO_PRICE == 0;
    }
}
