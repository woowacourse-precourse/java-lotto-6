package lotto.domain.validator;

import lotto.util.constants.ValidateConstants;

public class BonusNumberValidator implements Validator<String> {
    @Override
    public void validate(String BonusNumber) {
        validateNumeric(BonusNumber);
        validateRange(BonusNumber);
    }

    public void validateNumeric(String BonusNumber) {
        if (BonusNumber.matches(ValidateConstants.NUMERIC_REGEX.getConstants())) {
            return;
        }
        throw new IllegalArgumentException(ValidateConstants.BONUS_NUMERIC_ERROR.getConstants());
    }

    public void validateRange(String BonusNumber) {

        int min = ValidateConstants.LOTTO_MIN_NUMBER.getNumberConstants();
        int max = ValidateConstants.LOTTO_MAX_NUMBER.getNumberConstants();

        if (Integer.parseInt(BonusNumber) < min || Integer.parseInt(BonusNumber) > max) {
            throw new IllegalArgumentException(ValidateConstants.WINNER_NUMBER_RANGE_ERROR.getConstants());
        }
    }
}
