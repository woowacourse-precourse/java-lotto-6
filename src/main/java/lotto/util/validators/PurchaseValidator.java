package lotto.util.validators;

import lotto.util.exception.input.NumbersCannotEmpty;
import lotto.util.exception.operation.AmountDivisionException;
import lotto.util.exception.operation.AmountLessThanZeroException;
import lotto.util.exception.operation.AmountParseException;

/**
 * 로또 구매 금액 입력을 검증하는 검사기
 */
public class PurchaseValidator {
    private final static int THOUSAND = 1000;
    private final static int ZERO = 0;

    public static void validatePurchase(String amount) {
        validateEmpty(amount);
        Integer validatedAmount = validateInteger(amount);
        divisibilityByThousand(validatedAmount);
        validateGreaterThanZero(validatedAmount);
    }

    private static void validateEmpty(String amount) {
        if (amount.isEmpty()) {
            throw new NumbersCannotEmpty();
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
