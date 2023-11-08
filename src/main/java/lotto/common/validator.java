package lotto.common;

import static lotto.common.ErrorMessage.*;

public class validator {

    public static int isValidPurchaseAmout(String amoutInput) {
        try {
            int price = Integer.parseInt(amoutInput);
            if (price % 1000 != 0) {
                throw new IllegalArgumentException(INPUT_MULTIPLES_ERROR.getMessage());
            }
            return price;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INPUT_TYPE_STRING_ERROR.getMessage());
        }
    }
}
