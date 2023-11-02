package lotto.validation;

import java.util.List;
import java.util.stream.Collectors;
import lotto.enums.ErrorMessage;

public class NumberValidator {
    private static final int MIN_NUMBER_RANGE = 1;
    private static final int MAX_NUMBER_RANGE = 45;
    private static final int WINNING_NUMBER_SIZE = 6;

    private NumberValidator() {
    }

    public static void validate(List<Integer> numbers) {
        validateNumberSize(numbers);
        validateDuplication(numbers);
        for (Integer number : numbers) {
            validateNumberRange(number);
        }
    }

    private static void validateNumberRange(int number) {
        if (number < MIN_NUMBER_RANGE || number > MAX_NUMBER_RANGE) {
            throw new IllegalArgumentException(ErrorMessage.NUMBER_RANGE.getMessage());
        }
    }

    private static void validateNumberSize(List<Integer> numbers) {
        if (numbers.size() != WINNING_NUMBER_SIZE) {
            throw new IllegalArgumentException(ErrorMessage.NUMBER_SIZE.getMessage());
        }
    }

    private static void validateDuplication(List<Integer> numbers) {
        int deDuplicatedCount = numbers.stream()
                .collect(Collectors.toSet())
                .size();
        if (numbers.size() != deDuplicatedCount) {
            throw new IllegalArgumentException(ErrorMessage.NUMBER_DUPLICATION.getMessage());
        }
    }
}
