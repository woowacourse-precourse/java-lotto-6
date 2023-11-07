package lotto.model;

import static lotto.constants.LottoConstants.LOTTO_SIZE;
import static lotto.constants.LottoConstants.MAX_RANGE;
import static lotto.constants.LottoConstants.MIN_RANGE;

import java.util.HashSet;
import java.util.List;
import lotto.exceptionMessages.ExceptionMessages;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException(ExceptionMessages.EXCEPTION_NUMBER_SIZE.getMessage());
        }
        if (isInvalidRange(numbers)) {
            throw new IllegalArgumentException(ExceptionMessages.EXCEPTION_NUMBER_RANGE.getMessage());
        }
        if (isDuplicate(numbers)) {
            throw new IllegalArgumentException(ExceptionMessages.EXCEPTION_NUMBER_DUPLICATION.getMessage());
        }
    }

    private boolean isInvalidRange(List<Integer> numbers) {
        return numbers.stream()
                .anyMatch(number -> number < MIN_RANGE || number > MAX_RANGE);
    }

    private boolean isDuplicate(List<Integer> numbers) {
        HashSet<Integer> unique = new HashSet<>(numbers);
        return unique.size() != numbers.size();
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}