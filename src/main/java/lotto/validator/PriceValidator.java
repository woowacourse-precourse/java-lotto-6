package lotto.validator;

import lotto.domain.constants.LottoConstraint;
import lotto.domain.message.ErrorMessage;
import lotto.view.InputView;

public class PriceValidator extends Validator{
    public static void validate(String price){
        validateNumber(price);
        validatePriceRange(Integer.parseInt(price));
    }

    private static void validatePriceRange(int price) {
        if (price % LottoConstraint.LOTTO_PRICE.getValue() != 0) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_MONEY_VALUE.value());
        }
    }
}
