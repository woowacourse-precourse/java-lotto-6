package lotto.service;

import static lotto.constant.Constant.EXCEPTION_ISSUE_LOTTO;

public class Validation {

    public Integer validatePriceAndReturnNumber(String price) {
        Integer validatedPrice = null;
        try {
            validatedPrice = Integer.parseInt(price);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(EXCEPTION_ISSUE_LOTTO);
        }
        if (validatedPrice % 1000 != 0) {
            throw new IllegalArgumentException(EXCEPTION_ISSUE_LOTTO);
        }
        return validatedPrice/1000;
    }
}
