package lotto.domain;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private static final String NON_NUMBER_SIZE_SIX_ERROR_MESSAGE = "[ERROR] 로또 번호는 6개입니다.";
    private static final String NUMBER_DUPLICATE_ERROR_MESSAGE = "[ERROR] 로또 번호는 중복 불가합니다.";
    private static final int PROPER_NUMBERS_SIZE = 6;

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != PROPER_NUMBERS_SIZE) {
            throw new IllegalArgumentException(NON_NUMBER_SIZE_SIX_ERROR_MESSAGE);
        }
        if (isNumbersDuplicate(numbers)) {
            throw new IllegalArgumentException(NUMBER_DUPLICATE_ERROR_MESSAGE);
        }
    }

    private boolean isNumbersDuplicate(List<Integer> numbers) {
        Set<Integer> duplicateNumbers = new HashSet<>(numbers);
        return duplicateNumbers.size() != PROPER_NUMBERS_SIZE;
    }

    public List<Integer> getNumbers() {
        return Collections.unmodifiableList(numbers);
    }
}
