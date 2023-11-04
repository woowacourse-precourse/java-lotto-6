package lotto;

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

        validateDuplicate(numbers);
    }

    // TODO: 추가 기능 구현
    private void validateDuplicate(List<Integer> numbers) {

        for (int number : numbers) {

            if (numbers.contains(number)) {

                throw new IllegalArgumentException();
            }
        }
    }
}
