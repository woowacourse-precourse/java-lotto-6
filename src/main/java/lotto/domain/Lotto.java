package lotto.domain;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (checkNumbersCount(numbers) || hasDuplicates(numbers)) {
            throw new IllegalArgumentException();
        }
    }

    private boolean checkNumbersCount(List<Integer> numbers) {
        return numbers.size() != 6;
    }

    private boolean hasDuplicates(List<Integer> numbers) {
        return numbers.stream().distinct().count() != numbers.size();
    }
}
