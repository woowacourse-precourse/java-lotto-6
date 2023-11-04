package lotto.domain;

import java.util.List;

public class Lotto {

    private static final int NUMBERS_LENGTH = 6;
    private static final String LENGTH_ERROR_MESSAGE = "[ERROR] 로또 번호는 6개여야 합니다.";

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        validateNumbersSize(numbers);
        validateDuplicationInNumbers(numbers);
    }

    private static void validateNumbersSize(final List<Integer> numbers) {
        if (numbers.size() != NUMBERS_LENGTH) {
            throw new IllegalArgumentException(LENGTH_ERROR_MESSAGE);
        }
    }

    private void validateDuplicationInNumbers(final List<Integer> numbers) {
        if (hasDuplication(numbers)) {
            throw new IllegalArgumentException("[ERROR] 로또 번호에 중복된 숫자가 존재할 수 없습니다.");
        }
    }

    private boolean hasDuplication(final List<Integer> numbers) {
        return NUMBERS_LENGTH != numbers.stream()
                .distinct()
                .count();
    }

}
