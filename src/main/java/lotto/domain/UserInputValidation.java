package lotto.domain;

import static lotto.util.ErrorMessage.INPUT_MULTIPLES_OF_1000_ERROR;
import static lotto.util.ErrorMessage.INPUT_STRING_ERROR;

public class UserInputValidation {

    public static int isValidPurchaseAmount(String input) {
        try {
            int result = Integer.parseInt(input);

            if(result % 1000 != 0) {
                throw new IllegalArgumentException(INPUT_MULTIPLES_OF_1000_ERROR.getMessage());
            }

            return result;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INPUT_STRING_ERROR.getMessage());
        }

    }

}
