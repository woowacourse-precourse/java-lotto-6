package lotto.util.validator;

import lotto.util.validator.constant.ErrorMessageConstant;

import java.util.Arrays;

public class LottoInputValidator implements InputValidator{
    @Override
    public void validate(String checkValue) {

    }

    private static void validateCount(String[] checkValues) {
        if(checkValues.length != 6) {
            throw new IllegalArgumentException(ErrorMessageConstant.LOTTO_LENGTH_NOT_SIX_MESSAGE.getMessage());
        }
    }
    private static void validateConsistingNumber(String[] checkValues) {
        try {
            for(int i = 0; i < checkValues.length; i++) {
                int number = Integer.parseInt(checkValues[i]);
            }
        }catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessageConstant.LOTTO_NUMBER_IS_NOT_NUMERIC.getMessage());
        }
    }
}
