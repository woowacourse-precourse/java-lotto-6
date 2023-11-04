package lotto.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.util.ValidationUtils;

public class Lotto {

    private final List<Integer> numbers;
    private final int LOTTO_SIZE_CRITERION = 6;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        ValidationUtils.validateNotNull(numbers);
        validateSizeOfNumbers(numbers);
        validateDuplicatedNumbers(numbers);
    }

    private void validateSizeOfNumbers(List<Integer> numbers) {
        if (numbers.size() != LOTTO_SIZE_CRITERION) {
            throw new IllegalArgumentException();
        }
    }

    private void validateDuplicatedNumbers(List<Integer> numbers) {
        Set<Integer> set = new HashSet<>(numbers);
        if (numbers.size() != LOTTO_SIZE_CRITERION) {
            throw new IllegalArgumentException();
        }
    }
}
