package lotto.domain;

import lotto.util.Util;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
        if (isDuplicateNumber(numbers)) {
            throw new IllegalArgumentException();
        }
    }

    public boolean isDuplicateNumber(List<Integer> numbers) {
        return numbers.size() != Util.distinctListSize(numbers);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
