package lotto.global.validator;

import lotto.domain.model.LottoPrice;
import lotto.domain.view.OutputType;
import lotto.global.error.ErrorType;

public class Validator {
    public boolean isValidatePurchasePrice(String userInputPrice) {
        try {
            int userPurchasePrice = Integer.parseInt(userInputPrice);

            if (userPurchasePrice % LottoPrice.LOTTO_PRICE.getValue() != 0) {
                throw new IllegalArgumentException(ErrorType.DIVIDABLE_1000_MESSAGE.getValue());
            }

        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }
}
