package lotto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WinnerNumbers {

    private static final int LOTTO_NUMBER_SIZE = LottoConstant.LOTTO_NUMBER_SIZE.getValue();
    private static final String ERROR_NOT_NUMBERS_SIZE = Message.ERROR_NOT_NUMBERS_SIZE.getValue();
    private static final String ERROR_DUPLICATE_NUMBERS = Message.ERROR_DUPLICATE_NUMBERS.getValue();

    private final List<Integer> numbers;

    WinnerNumbers(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        validateNumberSize(numbers);
        validDuplicateNumber(numbers);
    }

    private void validateNumberSize(List<Integer> numbers) {
        if (numbers.size() != LOTTO_NUMBER_SIZE) {
            throw new IllegalArgumentException(ERROR_NOT_NUMBERS_SIZE);
        }
    }

    private void validDuplicateNumber(List<Integer> numbers) {

        Set<Integer> notDuplicateNumbers = new HashSet<>(numbers);

        if (notDuplicateNumbers.size() != numbers.size()) {
            throw new IllegalArgumentException(ERROR_DUPLICATE_NUMBERS);
        }
    }
}
