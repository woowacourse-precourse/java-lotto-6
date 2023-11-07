package lotto.domain;

import lotto.utils.InputException;

import java.util.List;

public class Lotto {
    private static final int LOTTO_SIZE = 6;
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        InputException.checkSize(numbers, LOTTO_SIZE);
        InputException.isDuplication(numbers);
        InputException.validateList(numbers);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
