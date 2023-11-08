package lotto.util.validator;

import lotto.model.constant.LottoConstant;
import lotto.util.validator.constant.ErrorMessageConstant;

public class BonusInputValidator implements InputValidator{

    @Override
    public void validate(String checkValue) {
        validateNumber(checkValue);
        validateNumberRange(checkValue);
    }

    private static void validateNumber(String checkValue) {
        try {
            int number = Integer.parseInt(checkValue);
        }catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessageConstant.BONUS_NUMBER_IS_NOT_NUMERIC.getMessage());
        }
    }

    private static void validateNumberRange(String checkValue) {
        int number = Integer.parseInt(checkValue);
        if(number < LottoConstant.LOTTO_NUMBER_MIN_RANGE.getNumber() || number > LottoConstant.LOTTO_NUMBER_MAX_RANGE.getNumber()) {
            throw new IllegalArgumentException(ErrorMessageConstant.BONUS_NUMBER_RANGE_ERROR_MESSAGE.getMessage());
        }
    }
}
