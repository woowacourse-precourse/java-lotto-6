package lotto.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.exceptions.ErrorMessages;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        validateForDuplicates(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(ErrorMessages.LENGTH_ERROR.getMessage());
        }
    }

    private void validateForDuplicates(List<Integer> numbers) {
        Set<Integer> numberSet = new HashSet<>(numbers);
        if (numberSet.size() != numbers.size()) {
            throw new IllegalArgumentException(ErrorMessages.DUPLICATE_ERROR.getMessage());
        }
    }
    public List<Integer> getNumbers() {
        return numbers;
    }

    public boolean containsBonusNumber(int bonusNumber) {
        return numbers.contains(bonusNumber);
    }
}
