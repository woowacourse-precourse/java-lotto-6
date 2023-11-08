package lotto.domain;

import java.util.List;

public class Numbers {
    private static final String INVALID_NUMBER_SIZE = "[ERROR] 6개의 숫자여야 합니다.";
    private static final String DUPLICATION_EXIST = "[ERROR] 로또 번호에는 중복되는 숫자가 없어야 합니다.";
    private static final int NUMBERS_SIZE = 6;
    private final List<Number> numbers;

    private Numbers(List<Integer> numbers) {
        validateNumbersSize(numbers);
        validateIsDuplicationExists(numbers);
        this.numbers = numbers.stream()
                .map(Number::from)
                .toList();
    }

    public static Numbers from(List<Integer> numbers) {
        return new Numbers(numbers);
    }

    public List<Integer> getValue() {
        return numbers.stream()
                .map(Number::getValue)
                .toList();
    }

    private void validateNumbersSize(List<Integer> numbers) {
        if (numbers.size() != NUMBERS_SIZE) {
            throw new IllegalArgumentException(INVALID_NUMBER_SIZE);
        }
    }

    private void validateIsDuplicationExists(List<Integer> numbers) {
        if (numbers.stream().distinct().count() != numbers.size()) {
            throw new IllegalArgumentException(DUPLICATION_EXIST);
        }
    }
}