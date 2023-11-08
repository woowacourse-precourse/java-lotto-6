package lotto.util.validator;

import lotto.util.validator.constant.ErrorMessageConstant;

public class BonusInputValidator implements InputValidator{

    @Override
    public void validate(String checkValue) {

    }

    private static void validateNumber(String checkValue) {
        try {
            int number = Integer.parseInt(checkValue);
        }catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessageConstant.BONUS_NUMBER_IS_NOT_NUMERIC.getMessage());
        }
    }

}
