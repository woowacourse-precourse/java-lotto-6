package lotto.model;

import lotto.validate.InvalidlputException;

import java.util.List;
import java.util.stream.Collectors;

public class Lotto {
    private final List<Integer> numbers;
    private static final int LOTTO_SIZE = 6;
    private static final int LOTTO_RANGE_MIN = 1;
    private static final int LOTTO_RANGE_MAX = 45;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        numbers = sortedNumbers(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException();
        }
    }

    // TODO: 추가 기능 구현

    public List<Integer> sortedNumbers(List<Integer> numbers){
        return numbers.stream()
                .sorted()
                .collect(Collectors.toList());
    }

    @Override
    public String toString() {
        return numbers.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(", ", "[", "]"));
    }

}
