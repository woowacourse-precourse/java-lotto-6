package lotto;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class Lotto {
    public static final int MAX_VALUE = 45;
    public static final int MIN_VALUE = 1;
    private static final int STANDARD_SIZE = 6;
    private final List<Integer> numbers; // 필드 고정, private 도 고정

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        hasStandardSize(numbers);
        hasDuplicatedNumber(numbers);
        hasOutOfRangeNumber(numbers);
    }

    private void hasStandardSize(List<Integer> numbers) {
        if (numbers.size() != STANDARD_SIZE) {
            throw new IllegalArgumentException(ErrorException.WRONG_LOTTO_SIZE.getErrorDescription());
        }
    }

    private void hasDuplicatedNumber(List<Integer> numbers) {
        if (numbers.size() != new HashSet<>(numbers).size()) {
            throw new IllegalArgumentException(ErrorException.DUPLICATED_NUMBER.getErrorDescription());
        }
    }

    private void hasOutOfRangeNumber(List<Integer> numbers) {
        if (numbers.stream()
                .filter(number -> ((number > MAX_VALUE) || (number < MIN_VALUE)))
                .findFirst()
                .isPresent()) {
            throw new IllegalArgumentException(ErrorException.OUT_OF_RANGE_NUMBER.getErrorDescription());
        }
    }

    public List<Integer> getNumbers() {
        return Collections.unmodifiableList(numbers);
    }
}
