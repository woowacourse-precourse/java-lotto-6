package lotto.util;

import static lotto.constant.ExceptionMessages.PURCHASE_AMOUNT_FORMAT_EXCEPTION_MESSAGE;

public class StringParser {

    public Integer parsePurchaseAmount(String str) {
        try {
            int parsed = Integer.parseInt(str);
            Validator.validatePositiveInteger(parsed);
            return parsed;
        } catch (Exception e) {
            throw new IllegalArgumentException(PURCHASE_AMOUNT_FORMAT_EXCEPTION_MESSAGE.toString());
        }
    }
}
