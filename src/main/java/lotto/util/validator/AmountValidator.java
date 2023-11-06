package lotto.util.validator;

import lotto.util.constants.DomainConstants;
import lotto.util.constants.InputConstants;

public class AmountValidator implements Validator{

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
        if (amountString.matches(InputConstants.INPUT_AMOUNT_REGEX.getInputMessage())) {
            return;
        }
        throw new IllegalArgumentException(InputConstants.INPUT_NUMERIC_ERROR.getInputMessage());
    }

    public void validateUnitThousand(String inputAmount) {
        if (Integer.parseInt(inputAmount) % DomainConstants.LOTTO_PRICE.getInt() == 0) {
            return;
        }
        throw new IllegalArgumentException(InputConstants.INPUT_UNIT_ERROR.getInputMessage());
    }
}
