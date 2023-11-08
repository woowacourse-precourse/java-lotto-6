package lotto.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.util.ErrorMessage;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateSize(numbers);
        validateDuplicate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(ErrorMessage.NUMBER_DUPLICATE_ERROR);
        }
    }
    private void validateDuplicate(List<Integer> numbers) {
        Set<Integer> set = new HashSet<>();
        for (Integer num : numbers) {
            set.add(num);
        }
        if(set.size() != numbers.size()) {
            throw new IllegalArgumentException(ErrorMessage.NUMBER_SIZE_ERROR);
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
