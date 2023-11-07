package validate;

import static constants.LottoErrorMessageConstants.*;

public class InputValidation {
    public static void validateNumericInput(String input) {
        if (!input.matches("^[0-9]+$")){
            throw new IllegalArgumentException(ERROR_MESSAGE_NON_NUMERIC_VALUE);
        }
    }
}
