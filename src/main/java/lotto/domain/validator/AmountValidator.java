package lotto.domain.validator;

import lotto.util.constants.DomainConstants;
import lotto.util.constants.ValidateConstants;

public class AmountValidator implements Validator<String> {

    @Override
    public void validate(String amount) {
        validateNumeric(amount);
        validateUnitThousand(amount);
    }

    public void validateNumeric(String amount) {
        if (amount.matches(ValidateConstants.NUMERIC_REGEX.getConstants())) {
            return;
        }
        throw new IllegalArgumentException(ValidateConstants.AMOUNT_NUMERIC_ERROR.getConstants());
    }

    public void validateUnitThousand(String amount) {

        int quotient = Integer.parseInt(amount) / DomainConstants.LOTTO_PRICE.getConstants();
        int remainder = Integer.parseInt(amount) % DomainConstants.LOTTO_PRICE.getConstants();

        if (remainder == 0 && quotient > 0) {
            return;
        }
        throw new IllegalArgumentException(ValidateConstants.AMOUNT_UNIT_ERROR.getConstants());
    }
}
