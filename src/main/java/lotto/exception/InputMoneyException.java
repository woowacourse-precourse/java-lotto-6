package lotto.exception;

import static lotto.exception.ErrorMessage.*;

public class InputMoneyException {
    private InputMoneyException() {
    }

    public static void validate(String money) {
        NotNumberValidate(money);
    }

    private static void NotNumberValidate(String money) {
        try {
            Integer.parseInt(money);
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException(ERROR.getMessage() + INPUT_NUMBER.getMessage());
        }
    }
}
