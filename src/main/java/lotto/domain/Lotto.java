package lotto.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private static final int LOTTO_NUMBER_COUNT = 6;

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (!validateNumbersSize(numbers)) {
            throw new IllegalArgumentException(); //TODO added Exception Message
        }

        if (!validateDuplicationNumbers(numbers)) {
            throw new IllegalArgumentException(); //TODO added Exception Message
        }
    }

    private boolean validateNumbersSize(List<Integer> numbers) {
        return numbers.size() == LOTTO_NUMBER_COUNT;
    }

    private boolean validateDuplicationNumbers(List<Integer> numbers) {
        Set<Integer> deduplicationNumbers = new HashSet<>(numbers);
        return deduplicationNumbers.size() == LOTTO_NUMBER_COUNT;
    }
}
