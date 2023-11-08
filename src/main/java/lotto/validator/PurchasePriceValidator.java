package lotto.validator;

import static lotto.constant.ErrorMessage.PRICE_NOT_DIVISIBLE_MESSAGE;
import static lotto.constant.LottoConstant.LOTTO_PRICE;

import lotto.view.Output;

/*
 *   구매금액에 대한 검증을 담당
 * */

public class PurchasePriceValidator {
    public static void indivisibleUnit(int price) {
        if (isIndivisibleUnit(price)) {
            Output.errorMessage(PRICE_NOT_DIVISIBLE_MESSAGE);
            throw new IllegalArgumentException(PRICE_NOT_DIVISIBLE_MESSAGE);
        }
    }

    private static boolean isIndivisibleUnit(int price) {
        if ((price % LOTTO_PRICE == 0) && (price != 0)) {
            return false;
        }
        return true;
    }

}
