package lotto.service;

import static lotto.constant.Constant.LOTTO_PRICE_FOR_ONE;
import static lotto.constant.ErrorMessage.*;

public class ValidateService {
    public int validateBuyLottoInput(String buyPriceInput) {
        int buyPrice = parseIntPrice(buyPriceInput);
        isMultipliesOf1000(buyPrice);
        return buyPrice;
    }

    private int parseIntPrice(String buyPriceInput) {
        int buyPrice;
        try {
            buyPrice = Integer.parseInt(buyPriceInput);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(ERROR_BUY_PRICE_IS_NOT_INTEGER);
        }
        return buyPrice;
    }

    private void isMultipliesOf1000(int buyPrice) {
        if (buyPrice % LOTTO_PRICE_FOR_ONE != 0) {
            throw new IllegalArgumentException(ERROR_BUY_PRICE_IS_NOT_MULTIPLE_Of_1000);
        }
    }
}
