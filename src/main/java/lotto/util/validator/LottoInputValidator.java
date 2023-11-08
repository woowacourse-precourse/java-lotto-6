package lotto.util.validator;

import lotto.model.constant.LottoConstant;
import lotto.util.ConvertUtil;
import lotto.util.validator.constant.ErrorMessageConstant;

import java.util.Arrays;

import static lotto.model.constant.LottoConstant.*;
import static lotto.util.validator.constant.ErrorMessageConstant.*;

public class LottoInputValidator implements InputValidator{
    @Override
    public void validate(String checkValue) {
        String[] checkValues = ConvertUtil.convertInputToLottoNumbers(checkValue);
        validateCount(checkValues);
        validateConsistingNumber(checkValues);
        validateNumberRange(checkValues);
        validateDuplicate(checkValues);
    }

    private static void validateCount(String[] checkValues) {
        if(checkValues.length != LOTTO_MAX_COUNT.getNumber()) {
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

    private static void validateDuplicate(String[] checkValues) {
        if(Arrays.stream(checkValues).distinct().count() != LOTTO_MAX_COUNT.getNumber()) {
            throw new IllegalArgumentException(LOTTO_NUMBER_DUPLICATE_MESSAGE.getMessage());
        }
    }

    private static boolean isValidRange(int number) {
        return number < LOTTO_NUMBER_MIN_RANGE.getNumber() || number > LOTTO_NUMBER_MAX_RANGE.getNumber();
    }
}
