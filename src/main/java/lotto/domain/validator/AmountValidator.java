package lotto.domain.validator;

import lotto.util.constants.DomainConstants;
import lotto.util.constants.ValidateConstants;

public class AmountValidator implements Validator<String>{

    @Override
    public boolean inputValidate(String amount) {
        return isAmountFormValidator(amount);
    }

    public boolean isAmountFormValidator(String inputAmount) {
        try {
            validateNumeric(inputAmount);
            validateUnitThousand(inputAmount);
            return false;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return true;
        }
    }

    public void validateNumeric(String amountString) {
        if (amountString.matches(ValidateConstants.NUMERIC_REGEX.getConstants())) {
            return;
        }
        throw new IllegalArgumentException(ValidateConstants.AMOUNT_NUMERIC_ERROR.getConstants());
    }

    public void validateUnitThousand(String inputAmount) {

        int quotient = Integer.parseInt(inputAmount) / DomainConstants.LOTTO_PRICE.getConstants();
        int remainder = Integer.parseInt(inputAmount) % DomainConstants.LOTTO_PRICE.getConstants();

        if (remainder == 0 && quotient > 0) {
            return;
        }
        throw new IllegalArgumentException(ValidateConstants.AMOUNT_UNIT_ERROR.getConstants());
    }
}
