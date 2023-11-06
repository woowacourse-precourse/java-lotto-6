package lotto.validator;

import static lotto.constant.ErrorMessage.NOT_DIVISIBLE_BY_LOTTO_PRICE;
import static lotto.constant.NumericConstant.LOTTO_PRICE;

public class PurchaseMoneyValidator {

    private PurchaseMoneyValidator() {
    }

    public static void validate(String money) {
        CommonValidator.validateIsNaturalNumber(money);

        validateIsDivisibleByLottoPrice(money);
    }
    private static void validateIsDivisibleByLottoPrice(String money) {
        int amount = Integer.parseInt(money);

        if(amount % LOTTO_PRICE != 0 ) {
            throw new IllegalArgumentException(NOT_DIVISIBLE_BY_LOTTO_PRICE);
        }
    }


}
