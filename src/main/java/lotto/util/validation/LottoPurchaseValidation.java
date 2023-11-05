package lotto.util.validation;

import lotto.util.ErrorThrower;

import static lotto.config.ErrorMessage.NOT_THOUSAND_DIVIDED_ERROR;

public class LottoPurchaseValidation {

    public void validatorNotDivided(int purchaseAmount) {

        if (purchaseAmount % 1000 != 0) {
            ErrorThrower.throwIllegalStateException(NOT_THOUSAND_DIVIDED_ERROR.getMessage());
        }

    }

}
