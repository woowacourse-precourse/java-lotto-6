package lotto.model;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {

    private static final int LOTTO_NUMBER_COUNT = 6;
    private static final int MIN_LOTTO_NUMBER = 1;
    private static final int MAX_LOTTO_NUMBER = 45;

    public static final String ERROR_LOTTO_NUMBER_COUNT_MESSAGE = "[ERROR] 당첨 번호는 쉼표로 구분된 여섯개의 숫자여야 합니다.";
    public static final String ERROR_LOTTO_NUMBER_RANGE_MESSAGE = "[ERROR] 당첨 번호는 1이상 45이하의 숫자여야 합니다.";
    public static final String ERROR_LOTTO_NUMBER_DUPLICATE_MESSAGE = "[ERROR] 당첨 번호는 중복되지 않은 여섯개의 숫자여야 합니다.";

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        validateSize(numbers);
        validateRange(numbers);
        validateDuplicate(numbers);
    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException(ERROR_LOTTO_NUMBER_COUNT_MESSAGE);
        }
    }

    private void validateRange(List<Integer> numbers) {
        if (numbers.stream()
                .anyMatch(number -> number < MIN_LOTTO_NUMBER || number > MAX_LOTTO_NUMBER)) {
            throw new IllegalArgumentException(ERROR_LOTTO_NUMBER_RANGE_MESSAGE);
        }
    }

    private void validateDuplicate(List<Integer> numbers) {
        Set<Integer> numberSet = new HashSet<>(numbers);
        if (numberSet.size() != numbers.size()) {
            throw new IllegalArgumentException(ERROR_LOTTO_NUMBER_DUPLICATE_MESSAGE);
        }
    }

    public List<Integer> getNumbers() {
        return Collections.unmodifiableList(numbers);
    }

    // TODO: 추가 기능 구현
}
