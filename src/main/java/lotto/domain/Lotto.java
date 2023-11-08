package lotto.domain;

import java.util.Collections;
import java.util.List;

public class Lotto {

    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;
    private static final Integer LOTTO_SIZE = 6;
    private static final String NOT_SIX_NUMBERS_ERROR_MESSAGE = "[ERROR] 로또 번호는 중복되선 안됩니다.";
    private static final String NOT_CORRECT_NUMBER_RANGE_ERROR_MESSAGE = "[ERROR] 로또 번호는 1부터 45까지의 숫자여야 합니다.";
    private static final String SIZE_INSUFFICIENT_ERROR = "[ERROR] 로또 번호는 6개여야 합니다.";

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        validateDuplicatedNumber(numbers);
        validateCorrectNumberRange(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException(SIZE_INSUFFICIENT_ERROR);
        }
    }

    private void validateDuplicatedNumber(List<Integer> numbers) {
        if (numbers.stream().distinct().count() != LOTTO_SIZE) {
            throw new IllegalArgumentException(NOT_SIX_NUMBERS_ERROR_MESSAGE);
        }
    }

    private void validateCorrectNumberRange(List<Integer> numbers) {
        numbers.stream()
            .filter(number -> (number < MIN_NUMBER || number > MAX_NUMBER))
            .findAny()
            .ifPresent(number -> {
                throw new IllegalArgumentException(NOT_CORRECT_NUMBER_RANGE_ERROR_MESSAGE);
            });
    }

    public List<Integer> getLottoNumbers() {
        return Collections.unmodifiableList(numbers);
    }
}
