package lotto.util.validator;

import lotto.util.validator.constant.ErrorMessageConstant;

public class ParchaseAmountInputValidator implements InputValidator{
    @Override
    public void validate(String checkValue) {

    }

    private static void validateNumber(String checkValue) {
        try{
            int number = Integer.parseInt(checkValue);
        }catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessageConstant.PARCHASE_AMOUNT_IS_NOT_NUMERIC.getMessage());
        }
    }
}
