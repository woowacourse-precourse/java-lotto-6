package lotto.util;

import java.util.regex.Pattern;

import static lotto.constant.view.ErrorMessage.PURCHASE_REMINDER;
import static lotto.constant.view.ErrorMessage.PURCHASE_TYPE;
import static lotto.constant.LottoNumberComposition.MIN_PURCHASE_AMOUNT;

public class PurchaseValidator {
    public int validatePurchase(String amount) {
        validatePurchaseNumberType(amount);
        return validatePurchaseReminder(amount);
    }

    private void validatePurchaseNumberType(String amount) {
        String regex = "[0-9]+";

        if(!Pattern.matches(regex, amount)) {
            throw new IllegalArgumentException(PURCHASE_TYPE.getMessage());
        }
    }

    private int validatePurchaseReminder(String amount) {
        int purchaseAmount = Integer.parseInt(amount);
        if(purchaseAmount % MIN_PURCHASE_AMOUNT.getNumber() != 0) {
            throw new IllegalArgumentException(PURCHASE_REMINDER.getMessage());
        }
        return purchaseAmount;
    }
}
