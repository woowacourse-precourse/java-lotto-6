package lotto.validation;

import java.math.BigInteger;
import lotto.enums.LottoConstants;
import lotto.enums.LottoErrorCodes;

public class AmountValidator {

    public static int validateAmount(String amountStr) {

        BigInteger bigAmount = parseToBigInteger(amountStr);
        checkIntegerRange(bigAmount);
        int amount = bigAmount.intValueExact();
        validateMinimumAmount(amount);
        validateThousandUnit(amount);
        return amount;
    }

    private static BigInteger parseToBigInteger(String amount) {
        try {
            return new BigInteger(amount);
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException(LottoErrorCodes.INVALID_INTEGER_INPUT.getMessage());
        }
    }

    private static void checkIntegerRange(BigInteger bigAmount) {
        if (bigAmount.compareTo(BigInteger.valueOf(Integer.MAX_VALUE)) > 0 ||
                bigAmount.compareTo(BigInteger.valueOf(Integer.MIN_VALUE)) < 0) {
            throw new IllegalArgumentException(LottoErrorCodes.INTEGER_RANGE_EXCEEDED.getMessage());
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
