package lotto.model.domain;

import static lotto.util.Constants.MAX_NUMBER;
import static lotto.util.Constants.MIN_NUMBER;
import static lotto.util.ExceptionMessage.BONUS_ALREADY_CONTAIN_WINNING;
import static lotto.util.ExceptionMessage.COMMON_INVALID_RANGE;
import static lotto.util.ExceptionMessage.COMMON_INVALID_TYPE;

import java.util.List;

public class BonusValidator {

    public void validateNumberBetweenInRange(int bonus) {
        if(bonus < MIN_NUMBER || bonus > MAX_NUMBER) {
            throw new IllegalArgumentException(COMMON_INVALID_RANGE.format(MIN_NUMBER, MAX_NUMBER));
        }
    }

    public int validateBonusIsNumeric(String bonusNumber) {
        try {
            return Integer.parseInt(bonusNumber.trim());
        } catch (Exception e) {
            throw new IllegalArgumentException(COMMON_INVALID_TYPE.getMessage());
        }
    }

    public void validateWinningNumbersContainBonusNumber(List<Integer> winningNumbers, int bonusNumber) {
        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(BONUS_ALREADY_CONTAIN_WINNING.getMessage());
        }
    }

}
