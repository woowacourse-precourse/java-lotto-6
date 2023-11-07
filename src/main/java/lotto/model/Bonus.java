package lotto.model;

import java.util.List;
import lotto.constants.ErrorMessage;

public class Bonus {
    private final int number;

    public Bonus(int number, List<Integer> winningNumbers) {
        validateRange(number);
        validateDuplication(winningNumbers, number);
        this.number = number;
    }

    private static void validateRange(int bonusNumber) {
        if (bonusNumber < 1 || bonusNumber > 45) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_LOTTO_NUMBER.getMessage());
        }
    }

    private static void validateDuplication(List<Integer> winningNumbers, int bonusNumber) {
        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_BONUS_DUPLICATE.getMessage());
        }
    }

    public int getBonus() {
        return number;
    }
}
