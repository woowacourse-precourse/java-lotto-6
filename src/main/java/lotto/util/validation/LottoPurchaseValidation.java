package lotto.util.validation;

import lotto.util.ErrorThrower;

import static lotto.config.ErrorMessage.NOT_THOUSAND_DIVIDED_ERROR;

public class LottoPurchaseValidation {

    public void validatorNotDivided(String input) {

        int purchaseAmount = Integer.parseInt(input);

        if (purchaseAmount % 1000 != 0) {
            ErrorThrower.throwIllegalArgumentException(NOT_THOUSAND_DIVIDED_ERROR.getMessage());
        }

    }

}
