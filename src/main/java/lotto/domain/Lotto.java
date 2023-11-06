package lotto.domain;

import static lotto.config.GameNumberConfig.LOTTO_NUMBER_COUNT;
import static lotto.config.GameNumberConfig.LOTTO_RANGE_MAX;
import static lotto.config.GameNumberConfig.LOTTO_RANGE_MIN;
import static lotto.exception.ErrorMessage.VALIDATE_DUPLICATE;
import static lotto.exception.ErrorMessage.VALIDATE_LOTTO_SIZE;
import static lotto.exception.ErrorMessage.VALIDATE_LOTTO_SORT;
import static lotto.exception.ErrorMessage.VALIDATE_RANGE;

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
        checkDuplicate(numbers);
        checkRange(numbers);
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

    private void checkDuplicate(List<Integer> numbers) {
        long distinctCount = numbers.stream()
                .distinct()
                .count();
        if (numbers.size() > distinctCount) {
            throw new IllegalArgumentException(VALIDATE_DUPLICATE.getMessage());
        }
    }

    private static void checkRange(List<Integer> numbers) {
        for (int number : numbers) {
            if (number > LOTTO_RANGE_MAX.getNumber() || number < LOTTO_RANGE_MIN.getNumber()) {
                throw new IllegalArgumentException(VALIDATE_RANGE.getMessage());
            }
        }
    }

    public List<Integer> getLotto() {
        return numbers;
    }

    public boolean doesContain(int number) {
        return numbers.contains(number);
    }
}
