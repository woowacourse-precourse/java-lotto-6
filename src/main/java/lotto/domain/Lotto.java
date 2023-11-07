package lotto.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.util.SortedRandomNumberGenerator;

public class Lotto {
    public static final String INVALID_COUNT_MESSAGE = "로또 번호는 6개여야 합니다.";
    public static final String INVALID_RANGE_MESSAGE = "로또 번호의 숫자 범위는 1~45까지입니다.";
    public static final String DUPLICATE_NUMBER_MESSAGE = "숫자가 중복되지 않아야 합니다.";
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(INVALID_COUNT_MESSAGE);
        }
        for (int number : numbers) {
            validateNumberRange(number);
        }
        validateDuplicate(numbers);
    }

    public static void validateNumberRange(int number) {
        if (number < SortedRandomNumberGenerator.START_RANGE || number > SortedRandomNumberGenerator.END_RANGE) {
            throw new IllegalArgumentException(INVALID_RANGE_MESSAGE);
        }
    }

    public void validateDuplicate(List<Integer> numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        if (uniqueNumbers.size() < numbers.size()) {
            throw new IllegalArgumentException(DUPLICATE_NUMBER_MESSAGE);
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
