package lotto.domain.validator;

import java.util.List;
import lotto.domain.WinnerNumbers;
import lotto.util.constants.ValidateConstants;

public class BonusNumberValidator implements Validator<String> {
    @Override
    public void validate(String inputBonusNumber) {
        validateNumeric(inputBonusNumber);
        validateRange(inputBonusNumber);
    }

    public void validateNumeric(String inputBonusNumber) {
        if (inputBonusNumber.matches(ValidateConstants.NUMERIC_REGEX.getConstants())) {
            return;
        }
        throw new IllegalArgumentException(ValidateConstants.BONUS_NUMERIC_ERROR.getConstants());
    }

    public void validateRange(String inputBonusNumber) {

        int min = ValidateConstants.LOTTO_MIN_NUMBER.getNumberConstants();
        int max = ValidateConstants.LOTTO_MAX_NUMBER.getNumberConstants();

        if (Integer.parseInt(inputBonusNumber) < min || Integer.parseInt(inputBonusNumber) > max) {
            throw new IllegalArgumentException(ValidateConstants.BONUS_NUMBER_RANGE_ERROR.getConstants());
        }
    }

    public void validateDuplicateWinnerNumber(int bonusNumber, WinnerNumbers winnerNumbers) {
        List<Integer> numbers = winnerNumbers.getWinnerNumbers();
        if (numbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(ValidateConstants.BONUS_NUMBER_DUPLICATE_ERROR.getConstants());
        }
    }
}
