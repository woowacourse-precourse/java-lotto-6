package lotto.validator;

import lotto.view.ErrorMessage;

public class Validate {

    public static void moneyValidate(final String money) {
        if (!money.matches("^[0-9]*$")) {
            throw new IllegalArgumentException(ErrorMessage.TYPE_ERROR.getMessage());
        }
    }
}
