package lotto.util;

import lotto.constant.GameConstant;
import lotto.message.ValidateErrorMessage;

public class Validator {
    public int validate(int payment){
        if (payment % GameConstant.PAYMENT_UNIT != 0) {
            throw new IllegalArgumentException(ValidateErrorMessage.PAYMENT_ERROR.getMessage());
        }
        return payment;
    }
}
