package lotto.util.validator;

import lotto.util.validator.constant.ErrorMessageConstant;

import java.util.Arrays;

import static lotto.util.validator.constant.ErrorMessageConstant.*;

public class LottoInputValidator implements InputValidator{
    @Override
    public void validate(String checkValue) {

    }

    private static void validateCount(String[] checkValues) {
        if(checkValues.length != 6) {
            throw new IllegalArgumentException(LOTTO_LENGTH_NOT_SIX_MESSAGE.getMessage());
        }
    }
    private static void validateConsistingNumber(String[] checkValues) {
        try {
            Arrays.stream(checkValues).forEach(Integer::parseInt);
        }catch (NumberFormatException e) {
            throw new IllegalArgumentException(LOTTO_NUMBER_IS_NOT_NUMERIC.getMessage());
        }
    }

    private static void validateNumberRange(String[] checkValues) {
        if(Arrays.stream(checkValues)
                .mapToInt(Integer::parseInt)
                .anyMatch(LottoInputValidator::isValidRange)) {
            throw new IllegalArgumentException(LOTTO_NUMBER_RANGE_ERROR_MESSAGE.getMessage());
        }
    }

    private static boolean isValidRange(int number) {
        return number < 1 || number > 45;
    }
}
