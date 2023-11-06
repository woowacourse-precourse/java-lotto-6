package lotto.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.exception.DuplicateNumberException;

public class WinningNumber {
    private final List<Integer> numbers;
    private final int bonusNumber;

    public WinningNumber(List<Integer> numbers, int bonusNumber) {
        duplicateValidate(numbers);
        bonusNumDuplicate(numbers, bonusNumber);
        this.numbers = numbers;
        this.bonusNumber = bonusNumber;
    }

    private void bonusNumDuplicate(List<Integer> numbers, int bonusNumber) {
        if (numbers.contains(bonusNumber)) {
            throw new DuplicateNumberException();
        }
    }

    private static void duplicateValidate(List<Integer> numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>();

        for (int number : numbers) {
            if (uniqueNumbers.contains(number)) {
                throw new DuplicateNumberException();
            }
            uniqueNumbers.add(number);
        }
    }

}
