package lotto.domain;

import static lotto.enums.Constants.LOTTO_NUMBER_COUNT;
import static lotto.enums.ExceptionMessage.CONTAIN_DUPLICATE_DIGITS_EXCEPTION;
import static lotto.enums.ExceptionMessage.NOT_SIX_NUMBERS_EXCEPTION;
import static lotto.enums.ExceptionMessage.NUMBERS_WRONG_RANGE_EXCEPTION;

import java.util.List;
import java.util.stream.Collectors;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = sortAscending(numbers);
    }

    private void validate(List<Integer> numbers) {
        if (isNumbersCountNotSix(numbers)) {
            throw new IllegalArgumentException(NOT_SIX_NUMBERS_EXCEPTION.getMessage());
        }
        if (isNumbersWrongRange(numbers)) {
            throw new IllegalArgumentException(CONTAIN_DUPLICATE_DIGITS_EXCEPTION.getMessage());
        }
        if (isContainDuplicateDigits(numbers)) {
            throw new IllegalArgumentException(NUMBERS_WRONG_RANGE_EXCEPTION.getMessage());
        }
    }

    private boolean isNumbersCountNotSix(List<Integer> numbers) {
        return numbers.size() != LOTTO_NUMBER_COUNT.getNumber();
    }

    private boolean isNumbersWrongRange(List<Integer> numbers) {
        return numbers.stream()
                .anyMatch(number -> number < 1 || number > 45);
    }

    private boolean isContainDuplicateDigits(List<Integer> numbers) {
        return numbers.stream()
                .distinct().count() != LOTTO_NUMBER_COUNT.getNumber();
    }

    public List<Integer> sortAscending(List<Integer> numbers) {
        return numbers.stream()
                .sorted().collect(Collectors.toList());
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
