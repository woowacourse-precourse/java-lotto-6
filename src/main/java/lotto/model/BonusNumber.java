package lotto.model;

import static lotto.util.Constant.LOTTO_MAX_RANGE;
import static lotto.util.Constant.LOTTO_MIN_RANGE;
import static lotto.util.Constant.REGEX_NUMERIC;
import static lotto.util.ErrorMessage.ERROR_BONUS_DUPLICATE;
import static lotto.util.ErrorMessage.ERROR_BONUS_NUMERIC;
import static lotto.util.ErrorMessage.ERROR_BONUS_OUT_OF_RANGE;

import java.util.List;

public class BonusNumber {
    private final int bonusNumber;

    public BonusNumber(String input) {
        validateBonusNumberNumeric(input);
        int inputNumber = Integer.parseInt(input);
        validateRangeofBonusNumber(inputNumber);
        this.bonusNumber = inputNumber;
    }

    public static void validateDuplicate(List<Integer> winningNumbers, int bonusNumber) {
        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(ERROR_BONUS_DUPLICATE);
        }
    }

    private void validateRangeofBonusNumber(int number) {
        if (number < LOTTO_MIN_RANGE || number > LOTTO_MAX_RANGE) {
            throw new IllegalArgumentException(ERROR_BONUS_OUT_OF_RANGE);
        }
    }

    private void validateBonusNumberNumeric(String input) {
        if (!REGEX_NUMERIC.matcher(input).matches()) {
            throw new IllegalArgumentException(ERROR_BONUS_NUMERIC);
        }
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

}
