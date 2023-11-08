package lotto;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = sort(numbers);
    }

    private void validate(List<Integer> numbers) {
        validateSize(numbers);
        validateRange(numbers);
        validateDuplicate(numbers);
    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 숫자는 6개가 되어야 합니다.");
        }
    }

    private void validateRange(List<Integer> numbers) {
        for (int num : numbers) {
            if (num < 1 || num > 45) {
                throw new IllegalArgumentException("[ERROR] 1과 45 사이의 숫자만 가능합니다.");
            }
        }
    }

    private void validateDuplicate(List<Integer> numbers) {
        if (numbers.stream()
                .distinct()
                .count() != numbers.size()) {
            throw new IllegalArgumentException("[ERROR] 중복된 숫자가 존재합니다.");
        }
    }

    public List<Integer> getNumbers() {
        return Collections.unmodifiableList(numbers);
    }

    private List<Integer> sort(List<Integer> numbers) {
        return numbers.stream()
                .sorted()
                .collect(Collectors.toList());
    }

    @Override
    public String toString() {
        return Arrays.toString(numbers.toArray());
    }
}

