package lotto.lotto.entity;

import lotto.validator.ErrorMessage;

import java.util.List;

public class Lotto {

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.stream().distinct().toList().size() != 6) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_MESSAGE_PREFIX + ErrorMessage.ERROR_SIX_LOTTO_NUMBER);
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
