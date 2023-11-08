package lotto.validator;

import static lotto.constant.MessageConstants.*;
import static lotto.constant.NumberConstants.*;

import lotto.constant.MessageConstants;
import lotto.constant.NumberConstants;

public class PlayerValidator {
    public static int validateAmount(String imputAmount) {
        int amount;
        try {
            amount = Integer.parseInt(imputAmount);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(MessageConstants.NUMBER_ERROR_MESSAGE);
        }

        if (amount < NumberConstants.LOTTO_PRICE_UNIT) {
            throw new IllegalArgumentException(MessageConstants.NUMBER_MIN_ERROR_MESSAGE);
        }

        if (amount % NumberConstants.LOTTO_PRICE_UNIT != 0) {
            throw new IllegalArgumentException(MessageConstants.NUMBER_UNIT_ERROR_MESSAGE);
        }

        return amount;
    }
}
