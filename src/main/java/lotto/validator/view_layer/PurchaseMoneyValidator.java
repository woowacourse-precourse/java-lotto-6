package lotto.validator.view_layer;

import static lotto.constant.ErrorMessage.NOT_DIVISIBLE_BY_LOTTO_PRICE;
import static lotto.constant.NumericConstant.LOTTO_PRICE;

public class PurchaseMoneyValidator implements InputValidator {
    @Override
    public void validate(String input) {
        CommonValidator.validateIsNaturalNumber(input);

        validateIsDivisibleByLottoPrice(input);
    }

    private void validateIsDivisibleByLottoPrice(String money) {
        int amount = Integer.parseInt(money);

        if (amount % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException(NOT_DIVISIBLE_BY_LOTTO_PRICE);
        }
    }
}
