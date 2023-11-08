package lotto.domain;

import static lotto.message.ErrorMessage.LOTTO_DUPLICATE;
import static lotto.message.ErrorMessage.LOTTO_RANGE;
import static lotto.message.ErrorMessage.LOTTO_SIZE;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateLength(numbers);
        validationRange(numbers);
        validationDuplication(numbers);
        this.numbers = ascendingNumbers(numbers);
    }

    private void validateLength(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(LOTTO_SIZE.errorMessage());
        }
    }

    private void validationRange(List<Integer> numbers) {
        numbers.stream()
                .filter(number -> !(1 <= number && number <= 45))
                .findAny()
                .ifPresent(number -> {
                    throw new IllegalArgumentException(LOTTO_RANGE.errorMessage());
                });
    }

    private void validationDuplication(List<Integer> numbers) {
        if (numbers.size() != numbers.stream().distinct().count()) {
            throw new IllegalArgumentException(LOTTO_DUPLICATE.errorMessage());
        }
    }

    private List<Integer> ascendingNumbers(List<Integer> numbers) {
        List<Integer> sortedNumbers = new ArrayList<>(numbers);
        Collections.sort(sortedNumbers);
        return sortedNumbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
