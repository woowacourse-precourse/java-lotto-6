package lotto.validator;

import static lotto.validator.constants.Criteria.*;
import static lotto.validator.constants.ExceptionMessage.*;
import static lotto.validator.constants.Pattern.*;

public class PayAmountValidator {
    public void validate(String payAmount) {
        isBlank(payAmount);
        isNotNumeric(payAmount);
        cannotDivideOneThousand(payAmount);
    }

    private void isBlank(String payAmount) {
        if (payAmount == null || payAmount.isBlank()) {
            throw new IllegalArgumentException(BLANK_ERROR.message());
        }
    }

    private void isNotNumeric(String payAmount) {
        if (!payAmount.matches(NUMERIC.pattern())) {
            throw new IllegalArgumentException(NOT_NUMERIC_ERROR.message());
        }
    }

    private void cannotDivideOneThousand(String payAmount) {
        if (!payAmount.matches(DIVIDE_ONE_THOUSAND.pattern())) {
            throw new IllegalArgumentException(PAY_AMOUNT_ONE_THOUSAND_UNIT_ERROR.message());
        }
    }
}
