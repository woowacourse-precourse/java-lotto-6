package lotto.util.validation;

import lotto.util.ErrorThrower;

import static lotto.config.ErrorMessage.NOT_THOUSAND_DIVIDED_ERROR;
import static lotto.config.ErrorMessage.PURCHASE_ONLY_NUMBER_ERROR;

public class LottoPurchaseValidation {

    public void validatorPurchaseOnlyNumber(String purchase) {

        if (!purchase.matches("[0-9]+")) {
            ErrorThrower.throwIllegalArgumentException(PURCHASE_ONLY_NUMBER_ERROR.getMessage());
        }

    }

    public void validatorNotDivided(String purchase) {

        int purchaseAmount = Integer.parseInt(purchase);

        if (purchaseAmount % 1000 != 0) {
            ErrorThrower.throwIllegalArgumentException(NOT_THOUSAND_DIVIDED_ERROR.getMessage());
        }

    }

}
