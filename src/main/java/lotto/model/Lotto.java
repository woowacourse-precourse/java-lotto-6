package lotto.model;

import lotto.config.ErrorMessage;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = getSortedNumbers(numbers);
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_LOTTO_SIZE.getErrorMessage());
        }
    }
    // TODO: 추가 기능 구현
    private List<Integer> getSortedNumbers(List<Integer> numbers) {
        return numbers.stream().sorted().toList();
    }
    @Override
    public String toString() {
        return numbers.toString();
    }
}
