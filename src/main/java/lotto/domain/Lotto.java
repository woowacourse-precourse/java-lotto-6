package lotto.domain;

import lotto.constants.ErrorMessage;

import java.util.Collections;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = sortList(numbers);
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_IS_NOT_NUMBER.getMessage());
        }
    }

    private List<Integer> sortList(List<Integer> numbers) {
        Collections.sort(numbers);
        return Collections.unmodifiableList(numbers);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
