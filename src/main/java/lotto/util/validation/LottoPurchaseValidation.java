package lotto.util.validation;

import lotto.util.ErrorThrower;

import static lotto.config.ErrorMessage.NOT_THOUSAND_DIVIDED_ERROR;
import static lotto.config.ErrorMessage.PURCHASE_ONLY_NUMBER_ERROR;

public class LottoPurchaseValidation {

    public void validatorPurchaseOnlyNumber(String input) {

        if (!input.matches("[0-9]+")) {
            ErrorThrower.throwIllegalArgumentException(PURCHASE_ONLY_NUMBER_ERROR.getMessage());
        }

    }

    public void validatorNotDivided(String input) {

        int purchaseAmount = Integer.parseInt(input);

        if (purchaseAmount % 1000 != 0) {
            ErrorThrower.throwIllegalArgumentException(NOT_THOUSAND_DIVIDED_ERROR.getMessage());
        }

    }

}
