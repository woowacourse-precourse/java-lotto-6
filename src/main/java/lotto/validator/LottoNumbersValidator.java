package lotto.validator;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LottoNumbersValidator {

    private final static int NUMBERS_LENGTH = 6;

    public void validate(List<Integer> numbers) {
        throwIfNumbersLengthIsNotSix(numbers);
        throwIfContainsDuplicateNumbers(numbers);
    }

    private void throwIfNumbersLengthIsNotSix(List<Integer> numbers) {
        if (numbers.size() != NUMBERS_LENGTH) {
            throw new IllegalArgumentException();
        }
    }

    private void throwIfContainsDuplicateNumbers(List<Integer> numbers) {
        Set<Integer> duplicateChecker = new HashSet<>(numbers);
        if (duplicateChecker.size() != NUMBERS_LENGTH) {
            throw new IllegalArgumentException();
        }
    }
}
