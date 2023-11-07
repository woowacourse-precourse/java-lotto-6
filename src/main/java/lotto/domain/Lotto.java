package lotto.domain;

import lotto.constant.ErrorMessage;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateSize(numbers);
        validateRange(numbers);
        validateDuplicate(numbers);
        this.numbers = numbers;
    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_LOTTO_SIZE.toMessage());
        }
    }

    private void validateRange(List<Integer> numbers) {
        for(Integer number : numbers) {
            if(number < 1 || number > 45) {
                throw new IllegalArgumentException(ErrorMessage.OUT_OF_BOUND_LOTTO_NUMBER.toMessage());
            }
        }
    }

    private void validateDuplicate(List<Integer> numbers) {
        if(numbers.stream().distinct().count() != 6)
            throw new IllegalArgumentException(ErrorMessage.DUPLICATE_LOTTO_NUMBER.toMessage());
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
