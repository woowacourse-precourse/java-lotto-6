package lotto.model;

import java.util.List;
import lotto.utils.constant.ErrorMessage;

public class BonusNumber {
    private final static int MIN_RANGE = 1;
    private final static int MAX_RANGE = 45;
    private final int bonus;

    public BonusNumber(int bonus, List<Integer> winningNumbers) {
        this.bonus = bonus;
        validateOutOfRange(bonus);
        validateDuplication(winningNumbers);
    }

    public int getBonus() {
        return bonus;
    }

    private void validateDuplication(List<Integer> winningNumbers) {
        if (winningNumbers.contains(bonus)) {
            throw new IllegalArgumentException(ErrorMessage.BONUS_DUPLICATION_ERROR_MESSAGE.getMessage());
        }
    }

    private void validateOutOfRange(int bonus) {
        if (bonus < MIN_RANGE || bonus > MAX_RANGE) {
            throw new IllegalArgumentException(ErrorMessage.BONUS_OUT_OF_RANGE.getMessage());
        }
    }
}
