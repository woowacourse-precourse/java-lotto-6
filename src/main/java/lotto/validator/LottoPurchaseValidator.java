package lotto.validator;

import static lotto.constants.LottoConstants.LOTTO_PRICE;
import static lotto.constants.ValidationConstants.ERROR_INVALID_PURCHASE_AMOUNT;

public class LottoPurchaseValidator {
    private LottoPurchaseValidator() {
    }

    public static void validatePurchase(final int amount) {
        validateAmountForThousand(amount);
    }

    private static void validateAmountForThousand(int amount) {
        if (amount % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException(ERROR_INVALID_PURCHASE_AMOUNT.getMessage());
        }
    }
}
