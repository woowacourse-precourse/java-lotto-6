package lotto.util.validate;

import static lotto.util.Constant.*;
import static lotto.util.ErrorMessage.*;

public class PurchaseMoneyValidator {

    public static void validate(String purchaseMoney) {
        InputValidator.validateInput(purchaseMoney);
        checkPurchaseMoneyDivisible(purchaseMoney);
    }

    private static void checkPurchaseMoneyDivisible(String purchaseMoney) {
        if (isNotDivisibleWithLottoPrice(purchaseMoney)) {
            throw new IllegalArgumentException(INVALID_INPUT_PURCHASE_MONEY.getMessage());
        }
    }

    private static boolean isNotDivisibleWithLottoPrice(String purchaseMoney) {
        return Integer.parseInt(purchaseMoney) % LOTTO_PRICE != 0;
    }
}
