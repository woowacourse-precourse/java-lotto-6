package lotto.domain;

import lotto.constant.ErrorMessage;

import java.util.List;

public class Lotto {
    private static final int LOTTO_NUMBER_SIZE = 6;

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (!isSizeSix(numbers)) {
            ErrorMessage.LOTTO_WRONG_NUMBER_SIZE.throwIllegalArgumentException();
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    private boolean isSizeSix(List<Integer> numbers) {
        return numbers.size() == LOTTO_NUMBER_SIZE;
    }
}
