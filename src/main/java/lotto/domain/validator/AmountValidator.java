package lotto.domain.validator;

import lotto.util.constants.DomainConstants;
import lotto.util.constants.ValidateConstants;

public class AmountValidator implements Validator<String> {

    @Override
    public void validate(String inputAmount) {
        validateNumeric(inputAmount);
        validateUnitThousand(inputAmount);
    }

    public void validateNumeric(String inputAmount) {
        if (inputAmount.matches(ValidateConstants.NUMERIC_REGEX.getMessage())) {
            return;
        }
        throw new IllegalArgumentException(ValidateConstants.AMOUNT_NUMERIC_ERROR.getMessage());
    }

    public void validateUnitThousand(String inputAmount) {

        int quotient = Integer.parseInt(inputAmount) / DomainConstants.LOTTO_PRICE.getNumber();
        int remainder = Integer.parseInt(inputAmount) % DomainConstants.LOTTO_PRICE.getNumber();

        if (remainder == 0 && quotient > 0) {
            return;
        }
        throw new IllegalArgumentException(ValidateConstants.AMOUNT_UNIT_ERROR.getMessage());
    }
}
