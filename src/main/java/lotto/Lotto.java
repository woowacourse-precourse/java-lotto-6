package lotto;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;
    private static final int SIZE = 6;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != SIZE) {
            throw new IllegalArgumentException();
        }
        if (duplicated(numbers)) {
            throw new IllegalArgumentException();
        }
    }

    private boolean duplicated(List<Integer> numbers) {
        long distinctSize = numbers.stream().
                distinct().
                count();
        return numbers.size() != distinctSize;
    }

    // TODO: 추가 기능 구현
}
