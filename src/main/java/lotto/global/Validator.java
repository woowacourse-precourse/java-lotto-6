package lotto.global;

import lotto.domain.LottoCondition;
import lotto.global.exception.ErrorMessage;

public class Validator {
    public static void checkAmount(Integer amount) {
        if (amount % LottoCondition.MONEY_UNIT != 0) {
            throw new IllegalArgumentException(ErrorMessage.ILLEGAL_AMOUNT);
        }
    }
}
