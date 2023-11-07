package lotto.model.validator;

import static lotto.util.ExceptionMessage.BIGGER_THAN_MAX_LOTTO_NUMBER;
import static lotto.util.ExceptionMessage.DUPLICATE_LOTTO_NUMBER;
import static lotto.util.ExceptionMessage.SMALLER_THAN_MIN_LOTTO_NUMBER;
import static lotto.util.LottoDetails.MAXIMUM_OF_LOTTO_NUMBER;
import static lotto.util.LottoDetails.MINIMUM_OF_LOTTO_NUMBER;

import java.util.List;

public class BonusNumberValidator {
    public void checkInRange(Integer bonusNumber) {
        checkMinimum(bonusNumber);
        checkMaximum(bonusNumber);
    }

    private void checkMinimum(Integer bonusNumber) {
        if (bonusNumber < MINIMUM_OF_LOTTO_NUMBER.getDetails()) {
            throw new IllegalArgumentException(SMALLER_THAN_MIN_LOTTO_NUMBER.getMessage());
        }
    }

    private void checkMaximum(Integer bonusNumber) {
        if (bonusNumber > MAXIMUM_OF_LOTTO_NUMBER.getDetails()) {
            throw new IllegalArgumentException(BIGGER_THAN_MAX_LOTTO_NUMBER.getMessage());
        }
    }

    public void checkDuplicateWithWinningNumbers(List<Integer> winningNumbers, Integer bonusNumber) {
        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(DUPLICATE_LOTTO_NUMBER.getMessage());
        }
    }
}
