package lotto.domain;

import static lotto.config.GameNumberConfig.LOTTO_NUMBER_COUNT;
import static lotto.exception.ErrorMessage.VALIDATE_LOTTO_SIZE;
import static lotto.exception.ErrorMessage.VALIDATE_LOTTO_SORT;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        checkSize(numbers);
        checkSort(numbers);
    }

    private void checkSize(List<Integer> numbers) {
        if (numbers.size() != LOTTO_NUMBER_COUNT.getNumber()) {
            throw new IllegalArgumentException(VALIDATE_LOTTO_SIZE.getMessage());
        }
    }

    private void checkSort(List<Integer> numbers) {
        List<Integer> sortedNumbers = new ArrayList<>(numbers);
        Collections.sort(sortedNumbers);
        if (!numbers.equals(sortedNumbers)) {
            throw new IllegalArgumentException(VALIDATE_LOTTO_SORT.getMessage());
        }
    }

    public List<Integer> getLotto() {
        return numbers;
    }
}
