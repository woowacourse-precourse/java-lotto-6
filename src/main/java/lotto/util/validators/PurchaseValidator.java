package lotto.util.validators;

import static lotto.util.Constants.THOUSAND;
import static lotto.util.Constants.ZERO;

import lotto.util.exception.input.NumbersNullException;
import lotto.util.exception.operation.AmountDivisionException;
import lotto.util.exception.operation.AmountLessThanZeroException;
import lotto.util.exception.operation.AmountParseException;


public class PurchaseValidator {
    public static void validatePurchase(String amount) {
        validateEmpty(amount);
        Integer validatedAmount = validateInteger(amount);
        validateGreaterThanZero(validatedAmount);
        divisibilityByThousand(validatedAmount);
    }

    private static void validateEmpty(String amount) {
        if (amount.isEmpty()) {
            throw new NumbersNullException();
        }
    }

    private static Integer validateInteger(String amount) {
        try {
            return Integer.valueOf(amount);
        } catch (NumberFormatException e) {
            throw new AmountParseException();
        }
    }

    private static void divisibilityByThousand(Integer amount) {
        if (amount % THOUSAND != ZERO) {
            throw new AmountDivisionException();
        }
    }

    private static void validateGreaterThanZero(Integer amount) {
        if (amount <= ZERO) {
            throw new AmountLessThanZeroException();
        }
    }
}
