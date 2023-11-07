package lotto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WinningLotto {
    private final List<Integer> numbers;
    private final Integer bonusNumber;

    public WinningLotto(List<Integer> numbers, Integer bonusNumber) {
        validateDuplicate(numbers);
        this.numbers = numbers;
        validateBonusNumberDuplicateInNumbers(bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    private void validateBonusNumberDuplicateInNumbers(Integer bonusNumber) {
        for (Integer number : numbers) {
            if (number.equals(bonusNumber)) {
                throw new IllegalArgumentException();
            }
        }
    }private void validateDuplicate(List<Integer> numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        if (numbers.size() != uniqueNumbers.size()) {
            throw new IllegalArgumentException();
        }
    }

    public Integer getBonusNumber() {
        return bonusNumber;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
