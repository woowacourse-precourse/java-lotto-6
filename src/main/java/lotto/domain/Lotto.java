package lotto.domain;

import java.util.List;

public class Lotto {

    private static final Integer LOTTO_SIZE = 6;
    private static final String NOT_SIX_NUMBERS_ERROR_MESSAGE = "[ERROR] 로또 번호는 중복되선 안됩니다.";

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        validateDuplicatedNumber(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException();
        }
    }

    private void validateDuplicatedNumber(List<Integer> numbers) {
        if (numbers.stream().distinct().count() != LOTTO_SIZE) {
            throw new IllegalArgumentException(NOT_SIX_NUMBERS_ERROR_MESSAGE);
        }
    }
}
