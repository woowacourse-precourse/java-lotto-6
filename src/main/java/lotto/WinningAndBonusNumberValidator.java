package lotto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.domain.Lotto;
import lotto.util.SortedRandomNumberGenerator;

public class WinningAndBonusNumberValidator {
    public static Lotto validateWinningNumber(List<Integer> winningNumber) {
        for (int number : winningNumber) {
            validateNumberRange(number);
        }
        validateDuplicate(winningNumber);
        return new Lotto(winningNumber);
    }

    public static int validateBonusNumber(List<Integer> winningNumber, int bonusNumber) {
        validateNumberRange(bonusNumber);
        validateDuplicate(winningNumber, bonusNumber);
        return bonusNumber;
    }

    private static void validateNumberRange(int number) {
        if (number < SortedRandomNumberGenerator.START_RANGE || number > SortedRandomNumberGenerator.END_RANGE) {
            throw new IllegalArgumentException();
        }
    }

    private static void validateDuplicate(List<Integer> numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        if (uniqueNumbers.size() < numbers.size()) {
            throw new IllegalArgumentException();
        }
    }

    private static void validateDuplicate(List<Integer> numbers, int number) {
        if (numbers.contains(number)) {
            throw new IllegalArgumentException();
        }
    }
}
