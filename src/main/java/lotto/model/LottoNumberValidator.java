package lotto.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import lotto.enums.ErrorMessage;

public class LottoNumberValidator {

    public static void validateNumbersSize(List<Integer> numbers) throws IllegalArgumentException {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(
                ErrorMessage.INVALID_NUMBERS_COUNT_ERROR.getMessage());
        }
    }

    public static void validateNumberRange(List<Integer> numbers) throws IllegalArgumentException {
        boolean isOutOfRange = numbers.stream().anyMatch(number -> number < 1 || number > 45);
        if (isOutOfRange) {
            throw new IllegalArgumentException(ErrorMessage.EXCEED_LOTTO_RANGE_ERROR.getMessage());
        }
    }

    public static void validateDuplicateNumbers(List<Integer> numbers)
        throws IllegalArgumentException {
        Set<Integer> uniqueNumbers = new HashSet<>();
        List<Integer> duplicateNumbers = numbers.stream()
            .filter(number -> !uniqueNumbers.add(number))
            .collect(Collectors.toList());

        if (!duplicateNumbers.isEmpty()) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATE_NUMBER_ERROR.getMessage());
        }
    }

}
