package lotto;

import java.util.List;

public class AnswerLotto {
    private final List<Integer> numbers;

    public AnswerLotto(List<Integer> numbers) {
        validateAnswerLotto(numbers);
        this.numbers = numbers;
    }

    private void validateAnswerLotto(List<Integer> numbers) {
        validateLength(numbers);
    }

    private void validateLength(List<Integer> numbers) {
        if (checkLength(numbers)) {
            throw new IllegalArgumentException();
        }
    }

    private boolean checkLength(List<Integer> numbers) {
        return numbers.size() != 6;
    }
}
