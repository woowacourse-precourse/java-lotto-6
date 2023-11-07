package lotto.model;

import lotto.view.ErrorConstants;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(ErrorConstants.ILLEGAL_LOTTO_SIZE_ERROR);
        }
        for (Integer number : numbers) {
            if (number < 0 || number > 45) {
                throw new IllegalArgumentException(ErrorConstants.ILLEGAL_LOTTO_NUMBER_ERROR);
            }
        }
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
