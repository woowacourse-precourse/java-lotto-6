package lotto.validation;

import java.util.List;

public class NumberCheckValidator {
    public static boolean validateWinningNumber(List<Integer> winningNumbers) {
        if (winningNumbers.size() != 6 || winningNumbers.stream().distinct().count() != 0) {
            return false;
        }
        if (winningNumbers.stream().filter(i -> i < 1 || i > 45).count() > 0) {
            return false;
        }
        return true;
    }

    public static boolean validateBonusNumber(List<Integer> winningNumbers, int bonusNumber) {
        if (winningNumbers.contains(bonusNumber)) {
            return false;
        }
        if (bonusNumber < 1 || bonusNumber > 45) {
            return false;
        }
        return true;
    }
}