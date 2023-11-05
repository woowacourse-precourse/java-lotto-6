package lotto.domain;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;
    public static final int NUMBERS_SIZE = 6;

    public Lotto(List<Integer> numbers) {
        validateNumbers(numbers);
        this.numbers = numbers;
    }

    private void validateNumbers(List<Integer> numbers) {
        validateNumbersSize(numbers);
        validateNumbersValue(numbers);
    }

    private void validateNumbersSize(List<Integer> numbers) {
        if (numbers.size() != NUMBERS_SIZE) {
            throw new IllegalArgumentException();
        }
    }

    private void validateNumbersValue(List<Integer> numbers) {
        for (int number : numbers) {
            if (numbers.contains(number)) {
                throw new IllegalArgumentException();
            }
        }
    }

    // TODO: 추가 기능 구현
}
