package lotto.util.validation;

import lotto.util.ErrorThrower;

import static lotto.config.ErrorMessage.ONLY_NUMBER_ERROR;

public class LottoValidation {

    public void validatorOnlyNumber(String input) {

        if (!input.matches("[1-9][0-9]*")) {
            ErrorThrower.throwIllegalArgumentException(ONLY_NUMBER_ERROR.getMessage());
        }

    }

}
