package lotto.util;

import static lotto.util.Constants.DIVISION_VALUE;
import static lotto.util.Constants.REMAINDER;
public class PurchaseAmountValidation {
    private PurchaseAmountValidation(){}
    public static boolean divisibleThousand(final String money) {
        return Integer.parseInt(money) / DIVISION_VALUE == REMAINDER;
    }
}
