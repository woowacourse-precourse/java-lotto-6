package lotto.validators;

import lotto.constant.ErrorMessages;

import java.util.List;

public class LottoValidator {
    public static void validateDuplicatedNumbers(List<Integer> numbers) {
        if (isDuplicatedNumbers(numbers)) {
            throw new IllegalArgumentException(ErrorMessages.DUPLICATE_NUMBER);
        }
    }

    private static boolean isDuplicatedNumbers(List<Integer> numbers) {
        int distinctNumbersSize = numbers.stream()
                .distinct()
                .toList()
                .size();

        return numbers.size() != distinctNumbersSize;
    }
}
