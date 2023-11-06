package lotto.model.domain;

import java.util.HashSet;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        validateDuplicateNum(numbers);
        validateOutOfRange(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    public List<Integer> getLotto(){return this.numbers;}

    public void validateDuplicateNum(List<Integer> numbers) {
        HashSet<Integer> validateSet = new HashSet<>();
        validateSet.addAll(numbers);
        if (validateSet.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    public void validateOutOfRange(List<Integer> numbers) {
        for (Integer number : numbers) {
            if (number > 45 || number < 1) {
                throw new IllegalArgumentException();
            }
        }
    }
}
