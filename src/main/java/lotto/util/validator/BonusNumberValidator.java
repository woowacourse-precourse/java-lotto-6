package lotto.util.validator;

import static lotto.util.Constant.*;
import static lotto.util.ErrorMessage.*;

import java.util.List;

public class BonusNumberValidator extends Validator {

    public Integer validate(String input) {
        validateNumber(input, BONUS_NUMBER_PATTERN);
        int number = Integer.parseInt(input);
        validateNumberRange(number);
        return number;
    }

    public static BonusNumberValidator createValidator() {
        return new BonusNumberValidator();
    }

    public void validateBonusNumber(List<Integer> winningNumbers, int number) {
        if (winningNumbers.contains(number)) {
            throw new IllegalArgumentException(DUPLICATE_NUMBER.getMessage());
        }
    }
}
