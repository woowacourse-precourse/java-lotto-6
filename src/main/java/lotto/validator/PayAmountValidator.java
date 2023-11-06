package lotto.validator;

import static lotto.validator.constants.Criteria.*;
import static lotto.validator.constants.ExceptionMessage.*;
import static lotto.validator.constants.Pattern.*;

public class PayAmountValidator implements Validator {
    public void validate(String payAmount) {
        isBlank(payAmount);
        isNotNumeric(payAmount);
        isInvalidDigits(payAmount);
        isInvalidRange(payAmount);
        cannotDivideOneThousand(payAmount);
    }

    private void isNotNumeric(String payAmount) {
        if (!payAmount.matches(NUMERIC.pattern())) {
            throw new IllegalArgumentException(NOT_NUMERIC_ERROR.message());
        }
    }

    private void isInvalidDigits(String payAmount) {
        if (payAmount.length() > MAX_NUMBER_DIGIT.criteria()) {
            throw new IllegalArgumentException(PAY_AMOUNT_DIGIT_EROOR.message());
        }
    }

    private void isInvalidRange(String payAmount) {
        long amount = Long.parseLong(payAmount);
        if (amount > MAX_PAY_AMOUNT.criteria()) {
            throw new IllegalArgumentException(PAY_AMOUNT_RANGE_ERROR.message());
        }
    }

    private void cannotDivideOneThousand(String payAmount) {
        if (!payAmount.matches(DIVIDE_ONE_THOUSAND.pattern())) {
            throw new IllegalArgumentException(PAY_AMOUNT_ONE_THOUSAND_UNIT_ERROR.message());
        }
    }
}
