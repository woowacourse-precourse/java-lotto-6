package lotto.domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    public static final int MIN_LOTTO_NUMBER = 1;
    public static final int MAX_LOTTO_NUMBER = 45;
    public static final int LOTTO_COUNT = 6;
    public static final int MIN_PRICE = 1000;
    public static final int LOTTO_PRICE = 1000;
    private static final String DUPLICATE_NUMBER_ERROR_MESSAGE = "[ERROR] 중복된 번호는 입력할 수 없습니다.";
    private static final String SIZE_ERROR_MESSAGE = "[ERROR] 번호의 개수는 6개입니다.";
    private static final String OUT_OF_RANGE_NUMBER_ERROR_MESSAGE = "[ERROR] 번호는 1~45 사이의 숫자여야합니다.";
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateSize(numbers);
        validateDuplicate(numbers);
        validateRange(numbers);
        this.numbers = numbers;
    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != LOTTO_COUNT) {
            throw new IllegalArgumentException(SIZE_ERROR_MESSAGE);
        }
    }

    // TODO: 추가 기능 구현
    public List<Integer> getNumbers() {
        return new ArrayList<>(numbers);
    }

    private void validateDuplicate(List<Integer> numbers) {
        Set<Integer> validDuplicateSet = new HashSet<>(numbers);
        if (validDuplicateSet.size() != numbers.size()) {
            throw new IllegalArgumentException(DUPLICATE_NUMBER_ERROR_MESSAGE);
        }
    }

    private void validateRange(List<Integer> numbers) {
        for (Integer number : numbers) {
            validateNumber(number);
        }
    }

    private void validateNumber(int number) {
        if ((number < MIN_LOTTO_NUMBER) || (number > MAX_LOTTO_NUMBER)) {
            throw new IllegalArgumentException(OUT_OF_RANGE_NUMBER_ERROR_MESSAGE);
        }
    }
}
