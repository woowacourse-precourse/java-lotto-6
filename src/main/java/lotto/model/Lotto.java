package lotto.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.utils.enums.ErrorMessage;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        validateDuplicatedNumber(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) throws IllegalArgumentException {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(ErrorMessage.LACK_NUMBER_COUNT.getMessage());
        }
    }

    private void validateDuplicatedNumber(List<Integer> numbers) throws IllegalArgumentException {
        Set<Integer> set = new HashSet<>(numbers);
        if (set.size() != numbers.size()) {
            throw new IllegalArgumentException(ErrorMessage.NOT_DUPLICATED.getMessage());
        }
    }

    public List<Integer> getNumbers() {
        return numbers.stream().toList();
    }
}
