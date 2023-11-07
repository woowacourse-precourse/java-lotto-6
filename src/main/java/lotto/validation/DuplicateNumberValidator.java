package lotto.validation;

import java.util.List;

import static lotto.message.ErrorMessage.DUPLICATE_NUMBER_EXCEPTION;
import static lotto.message.ErrorMessage.NUMBER_INDICATION;

public class DuplicateNumberValidator {
    public static void validateDuplicateNumbers(List<Integer> numbers) {
        for (int i = 0; i < numbers.size(); i++) {
            matchTwoNumbers(numbers, i);
        }
    }

    private static void matchTwoNumbers(List<Integer> numbers, int i) {
        for (int j = i + 1; j < numbers.size(); j++) {
            if (numbers.get(i) == numbers.get(j)) {
                throw new IllegalArgumentException(DUPLICATE_NUMBER_EXCEPTION
                        + (i + 1) + NUMBER_INDICATION + numbers.get(i) + ", "
                        + (j + 1) + NUMBER_INDICATION + numbers.get(j));
            }
        }
    }
}
