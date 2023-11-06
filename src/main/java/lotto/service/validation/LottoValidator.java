package lotto.service.validation;

import static lotto.io.message.ExceptionMessage.INVALID_PURCHASE_AMOUNT_MESSAGE;
import static lotto.service.LottoConstant.PURCHASE_AMOUNT_UNIT;

public class LottoValidator {

    public void verifyPurchaseAmount(String purchaseAmountInput) {

        int purchaseAmount;

        try {
            purchaseAmount = Integer.parseInt(purchaseAmountInput);
        } catch (NumberFormatException ex) {
            throw new IllegalArgumentException(INVALID_PURCHASE_AMOUNT_MESSAGE.getMessage());
        }

        if (purchaseAmount <= 0 || purchaseAmount % PURCHASE_AMOUNT_UNIT != 0) {
            throw new IllegalArgumentException(INVALID_PURCHASE_AMOUNT_MESSAGE.getMessage());
        }
    }
}
