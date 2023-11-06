package lotto.validation;

import lotto.constant.message.ErrorMessage;

public class Validator {
    public static void checkInputPriceValidation(int inputPrice) {
        if (inputPrice % 1000 != 0)
            throw new IllegalArgumentException(ErrorMessage.INVALID_PURCHASE_AMOUNT_UNIT);
    }
}
