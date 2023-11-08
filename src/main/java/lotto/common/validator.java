package lotto.common;

import static lotto.common.ErrorMessage.*;

public class validator {

    public static int isValidPurchaseAmout(String amoutInput) {
        try {
            int purchaseAmount = Integer.parseInt(amoutInput);
            if (purchaseAmount % 1000 != 0) {
                throw new IllegalArgumentException(INPUT_MULTIPLES_ERROR.getMessage());
            }
            return purchaseAmount;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INPUT_TYPE_STRING_ERROR.getMessage());
        }
    }
}
