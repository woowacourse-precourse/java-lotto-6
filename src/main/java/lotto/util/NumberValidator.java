package lotto.util;

import java.util.List;
import lotto.constants.ErrorMessages;
import lotto.constants.LottoValues;

public class NumberValidator {
    public static void verifyPurchaseAmount(Integer amount) {
        validateNull(amount, ErrorMessages.LLOTTO_PURCHASE_AMOUNT_NOT_NULL);
        validateNegative(amount, ErrorMessages.LOTTO_PURCHASE_AMOUNT_POSITIVE_ONLY);
        validateAmountUnit(amount, ErrorMessages.LOTTO_PURCHASE_AMOUNT_UNIT);
        validateMaxValue(amount, ErrorMessages.LOTTO_PURCHASE_AMOUNT_MAX);
    }

    private static void validateNull(Integer amount, ErrorMessages error) {
        if (amount == null) {
            throw new IllegalArgumentException(error.getMessage());
        }
    }

    private static void validateNegative(Integer amount, ErrorMessages error) {
        if (amount <= 0) {
            throw new IllegalArgumentException(error.getMessage());
        }
    }

    private static void validateAmountUnit(Integer amount, ErrorMessages error) {
        Integer amountUnit = LottoValues.AMOUNT_UNIT.getValue();
        if ((amount % amountUnit) != 0) {
            throw new IllegalArgumentException(error.getMessage(List.of(amountUnit)));
        }
    }

    private static void validateMaxValue(Integer amount, ErrorMessages error) {
        Integer maxValue = Integer.MAX_VALUE;
        if (amount > maxValue) {
            throw new IllegalArgumentException(error.getMessage(List.of(maxValue)));
        }
    }
}
