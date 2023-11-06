package lotto.validation;

import static lotto.messages.Constant.AMOUNT_UNIT;
import static lotto.messages.ErrorMessages.INCORRECT_PURCHASE_AMOUNT;
import static lotto.messages.ErrorMessages.TYPE_MISS_MATCHING;

public class PurchaseAmountCheckValidator {

    public static int validatePurchaseAmount(String stringPurchaseAmount) {
        int purchaseAmount = 0;

        try {
            purchaseAmount = Integer.parseInt(stringPurchaseAmount);
        } catch (Exception e) {
            throw new IllegalArgumentException(TYPE_MISS_MATCHING);
        }

        if (purchaseAmount % AMOUNT_UNIT != 0) {
            throw new IllegalArgumentException(INCORRECT_PURCHASE_AMOUNT);
        }
        return purchaseAmount;
    }
}