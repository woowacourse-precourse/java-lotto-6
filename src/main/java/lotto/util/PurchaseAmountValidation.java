package lotto.util;

import lotto.util.exception.ErrorMessage;

import static lotto.util.Constants.DIVISION_VALUE;
import static lotto.util.Constants.REMAINDER;
public class PurchaseAmountValidation {
    private PurchaseAmountValidation(){}
    public static void divisibleThousand(final String amount) {
        if(Integer.parseInt(amount) % DIVISION_VALUE != REMAINDER)
            throw new IllegalArgumentException(ErrorMessage.INVALID_DIVISIBLE_BY_THOUSAND.getErrorMessage());
    }
}
