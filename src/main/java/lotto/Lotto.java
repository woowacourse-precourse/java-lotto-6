package lotto;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        NumberSizeCheck(numbers);
        DuplicateNumberCheck(numbers);
        NumberRangeCheck(numbers);
    }

    private void NumberSizeCheck(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    // TODO: 추가 기능 구현
    private void DuplicateNumberCheck(List<Integer> numbers) {
        long count = numbers
                .stream()
                .distinct()
                .count();

        if (numbers.size() != count) {
            throw new IllegalArgumentException();
        }
    }

    private void NumberRangeCheck(List<Integer> numbers) {
        boolean overRangeResult = numbers.stream().anyMatch(num -> num <= 0 || num > 45);
        if (overRangeResult) {
            throw new IllegalArgumentException();
        }
    }
}
