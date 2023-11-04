package lotto.validator;

import static lotto.constant.ErrorMessage.PRICE_NOT_DIVISIBLE_MESSAGE;
import static lotto.constant.LottoConstant.LOTTO_PRICE;

import lotto.view.Output;

public class PurchasePriceValidator {
    public static void indivisibleUnit(int price) {
        if (isIndivisibleUnit(price)) {
            Output.errorMessage(PRICE_NOT_DIVISIBLE_MESSAGE);
            throw new IllegalArgumentException(PRICE_NOT_DIVISIBLE_MESSAGE);
        }
    }

    private static boolean isIndivisibleUnit(int price) {
        //상수화를 시키는 것이 오히려 가독성을 떨어뜨리는 느낌?
        if ((price % LOTTO_PRICE == 0) && (price != 0)) {
            return false;
        }
        return true;
    }

}
