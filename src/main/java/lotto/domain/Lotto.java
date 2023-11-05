package lotto.domain;

import lotto.utils.GameRules;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        numbers = sort(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != GameRules.NUMBERS_SIZE.getValue()) {
            throw new IllegalArgumentException();
        }
    }

    public List<Integer> sort(List<Integer> numbers) {
        return numbers.stream()
                .sorted()
                .collect(Collectors.toList());
    }

    public List<Integer> getNumber() {
        return Collections.unmodifiableList(numbers);
    }

    @Override
    public String toString() {
        return "[" + numbers + "]";
    }
}