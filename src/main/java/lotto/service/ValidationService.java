package lotto.service;

import lotto.constants.ErrorCode;
import lotto.constants.Value;

public class ValidationService {

    public void amountValidation(int amount) {
        if (amount < Value.LOTTO_TICKET_PRICE) {
            throw new IllegalArgumentException(ErrorCode.AMOUNT_INVALID.getMessage());
        }

        if (amount % Value.LOTTO_TICKET_PRICE != 0) {
            throw new IllegalArgumentException(ErrorCode.AMOUNT_UNIT.getMessage());
        }
    }
}
