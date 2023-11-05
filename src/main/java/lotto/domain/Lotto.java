package lotto.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.enums.ExceptionMessages;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6 || hasDuplicates(numbers)) {
            throw new IllegalArgumentException(ExceptionMessages.INVALID_LOTTO_NUMBERS.getMessage());
        }
    }

    // TODO: 추가 기능 구현
    private Boolean hasDuplicates(List<Integer> numbers) {
        Set<Integer> compareNumbers = new HashSet<>(numbers);
        return compareNumbers.size() != numbers.size();
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
