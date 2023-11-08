package lotto.validation;

import lotto.enums.LottoConstants;
import lotto.enums.LottoErrorCodes;

public class AmountValidator {

    public static int validateAmount(String amountStr) {
        int amount = parseToInt(amountStr);
        validateMinimumAmount(amount);
        validateThousandUnit(amount);
        return amount;
    }

    private static int parseToInt(String amount) {
        try {
            return Integer.parseInt(amount);
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException(LottoErrorCodes.INVALID_INTEGER_INPUT.getMessage());
        }
    }

    private static void validateMinimumAmount(int amount) {
        if (amount < LottoConstants.LOTTO_TICKET_PRICE.getValue()) {
            throw new IllegalArgumentException(LottoErrorCodes.MINIMUM_AMOUNT_ERROR.getMessage());
        }
    }

    private static void validateThousandUnit(int amount) {
        if (amount % LottoConstants.LOTTO_TICKET_PRICE.getValue() != 0) {
            throw new IllegalArgumentException(LottoErrorCodes.AMOUNT_UNIT_ERROR.getMessage());
        }
    }
}
