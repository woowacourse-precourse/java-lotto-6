package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.enums.ExceptionMessage;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = sortNumbers(numbers);
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            String error = String.format(ExceptionMessage.NUMBER_COUNT_ERROR.message, 6);
            throw new IllegalArgumentException(error);
        }
        if (validateDuplicateNumbers(numbers)) {
            throw new IllegalArgumentException(ExceptionMessage.BONUS_NUMBER_DUPLICATE_ERROR.message);
        }
    }

    private boolean validateDuplicateNumbers(List<Integer> numbers) {
        Set<Integer> dupNumbers = new HashSet<>(numbers);
        return numbers.size() != dupNumbers.size();

    }

    private List<Integer> sortNumbers(List<Integer> numbers) {
        List<Integer> sortedNumbers = new ArrayList<>(numbers);
        Collections.sort(sortedNumbers);
        return sortedNumbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
