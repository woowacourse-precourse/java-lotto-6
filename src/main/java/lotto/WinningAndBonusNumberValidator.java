package lotto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WinningAndBonusNumberValidator {
    public Lotto validateWinningNumber(List<Integer> winningNumber) {
        for (int number : winningNumber) {
            validateNumberRange(number);
        }
        validateDuplicate(winningNumber);
        return new Lotto(winningNumber);
    }

    public int validateBonusNumber(List<Integer> winningNumber, int bonusNumber) {
        validateNumberRange(bonusNumber);
        validateDuplicate(winningNumber, bonusNumber);
        return bonusNumber;
    }

    private void validateNumberRange(int number) {
        if (number < SortedRandomNumberGenerator.START_RANGE || number > SortedRandomNumberGenerator.END_RANGE) {
            throw new IllegalArgumentException();
        }
    }

    private void validateDuplicate(List<Integer> numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        if (uniqueNumbers.size() < numbers.size()) {
            throw new IllegalArgumentException();
        }
    }

    private void validateDuplicate(List<Integer> numbers, int number) {
        if (numbers.contains(number)) {
            throw new IllegalArgumentException();
        }
    }
}
