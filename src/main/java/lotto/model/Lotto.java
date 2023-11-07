package lotto.model;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Lotto {
    private static final int LOTTO_NUMBER_COUNT = 6;
    private static final String ERROR_MESSAGE_PREFIX = "[ERROR] ";
    private static final String NOT_SIX_NUMBERS_EXCEPTION = "발행된 로또 번호의 개수는 6개여야 합니다.";
    private static final String CONTAIN_DUPLICATE_DIGITS_EXCEPTION = "발행된 로또 번호의 개수는 6개여야 합니다.";
    private static final String NUMBERS_WRONG_RANGE_EXCEPTION = "발행된 로또 번호의 개수는 6개여야 합니다.";

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = sortAscending(numbers);
    }

    private void validate(List<Integer> numbers) {
        if (isNumbersCountNotSix(numbers)) {
            throw new IllegalArgumentException(ERROR_MESSAGE_PREFIX + NOT_SIX_NUMBERS_EXCEPTION);
        }
        if (isNumbersWrongRange(numbers)) {
            throw new IllegalArgumentException(ERROR_MESSAGE_PREFIX + NUMBERS_WRONG_RANGE_EXCEPTION);
        }
        if (isContainDuplicateDigits(numbers)) {
            throw new IllegalArgumentException(ERROR_MESSAGE_PREFIX + CONTAIN_DUPLICATE_DIGITS_EXCEPTION);
        }
    }

    private static boolean isNumbersCountNotSix(List<Integer> numbers) {
        return numbers.size() != LOTTO_NUMBER_COUNT;
    }

    private boolean isContainDuplicateDigits(List<Integer> numbers) {
        return numbers.stream()
                .distinct().count() != LOTTO_NUMBER_COUNT;
    }

    private boolean isNumbersWrongRange(List<Integer> numbers) {
        return numbers.stream()
                .anyMatch(number -> number < 1 || number > 45);
    }

    public List<Integer> sortAscending(List<Integer> numbers) {
        return numbers.stream().sorted().collect(Collectors.toList());
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
