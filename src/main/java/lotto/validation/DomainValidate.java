package lotto.validation;

import lotto.config.ConstantNum;
import lotto.config.ErrorMessage;

public class DomainValidate {
    private DomainValidate() {
    }

    public static void validateNumberInRange(int num) {
        if (num < ConstantNum.LOTTO_NUMBER_MIN.getNum() || num > ConstantNum.LOTTO_NUMBER_MAX.getNum()) {
            throw new IllegalArgumentException(ErrorMessage.NUMBER_IS_NOT_IN_RANGE.getMessage());
        }
    }
}
