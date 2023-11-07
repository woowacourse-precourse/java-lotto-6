package lotto.domain;

import lotto.view.ErrorMessage;

import java.util.Collections;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateSix(numbers);
        this.numbers = numbers;
        Collections.sort(numbers);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    private void validateSix(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_NOT_SIX_MESSAGE.getValue());
        }
    }
}
