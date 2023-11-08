package lotto.validator;

import java.util.HashSet;
import java.util.List;

import static lotto.constants.ExceptionMessages.*;

public record LottoValidator(List<String> numbers) {
    public LottoValidator {
        validateBlank(numbers);
        validateSize(numbers);
        validateNumber(numbers);
        validateDuplicate(numbers);
    }

    public void validateNumber(List<String> numbers) {
        String regex = "([1-9]|[1-4][0-5])";
        if (
                numbers.stream()
                        .anyMatch(number -> !number.matches(regex))
        ) {
            throw new IllegalArgumentException(INVALID_NUMBER_RANGE.getMessage());
        }
    }

    public void validateBlank(List<String> numbers) {
        if (numbers.stream().anyMatch(String::isBlank)) {
            throw new IllegalArgumentException(NOT_ALLOWED_BLANK_NUMBER.getMessage());
        }
    }

    private void validateSize(List<String> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(INVALID_WIN_NUMBER_SIZE.getMessage());
        }
    }

    private void validateDuplicate(List<String> numbers) {
        HashSet<String> nonDuplicateNumbers = new HashSet<>(numbers);
        if (nonDuplicateNumbers.size() != 6) {
            throw new IllegalArgumentException(NOT_ALLOWED_DUPLICATE_NUMBER.getMessage());
        }
    }
}
