package lotto.model;

import java.util.Collections;
import java.util.List;

import static lotto.constant.ErrorConstant.ERROR_PREFIX;

public class Lotto {

    private static final int CORRECT_NUMBERS_SIZE = 6;
    private static final String NOT_CORRECT_SIZE_ERROR_MESSAGE = "숫자 6개를 입력해 주세요.";
    private static final String DUPLICATE_NUMBER_ERROR_MESSAGE = "중복 되지 않는 값을 입력해 주세요.";
    private static final String NOT_CORRECT_RANGE_SIZE_ERROR_MESSAGE = "1~45 사이의 값을 입력해 주세요.";

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (isNotCorrectSize(numbers)) {
            throw new IllegalArgumentException(ERROR_PREFIX + NOT_CORRECT_SIZE_ERROR_MESSAGE);
        }
        if (isNumbersDuplicate(numbers)) {
            throw new IllegalArgumentException(ERROR_PREFIX + DUPLICATE_NUMBER_ERROR_MESSAGE);
        }
        if (isNumbersWrongRange(numbers)) {
            throw new IllegalArgumentException(ERROR_PREFIX + NOT_CORRECT_RANGE_SIZE_ERROR_MESSAGE);
        }
    }

    private boolean isNotCorrectSize(List<Integer> numbers) {
        return numbers.size() != CORRECT_NUMBERS_SIZE;
    }

    private boolean isNumbersDuplicate(List<Integer> numbers) {
        long numbersDistinctSize = numbers.stream()
                .distinct().count();
        return numbersDistinctSize != CORRECT_NUMBERS_SIZE;
    }

    private boolean isNumbersWrongRange(List<Integer> numbers) {
        long correntNumbersRangeCount = numbers.stream()
                .filter(number -> number >= 1 && number <= 45)
                .count();
        return correntNumbersRangeCount != CORRECT_NUMBERS_SIZE;
    }

    public List<Integer> getNumbers() {
        return Collections.unmodifiableList(numbers);
    }
}
