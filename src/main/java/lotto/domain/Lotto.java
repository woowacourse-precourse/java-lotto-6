package lotto.domain;

import java.util.Collections;
import java.util.List;
import lotto.validation.Error;

public class Lotto {
    private final static int COUNT = 6;
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != COUNT) {
            Error error = Error.COUNT_ERROR;
            throw new IllegalArgumentException(error.message());
        }
    }

    public String convertNumbersToString() {
        sortAsc(numbers);
        return numbers.toString();
    }

    public void sortAsc(List<Integer> numbers) {
        Collections.sort(numbers);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
