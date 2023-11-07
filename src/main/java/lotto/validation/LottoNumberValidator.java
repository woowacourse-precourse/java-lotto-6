package lotto.validation;

import java.util.List;

import static lotto.configuration.RandomNumberConfig.END_INCLUSIVE;
import static lotto.configuration.RandomNumberConfig.START_INCLUSIVE;
import static lotto.message.ErrorMessage.*;

public class LottoNumberValidator {
    public static void validateDuplicateNumbers(List<Integer> numbers) {
        for (int i = 0; i < numbers.size(); i++) {
            matchTwoNumbers(numbers, i);
        }
    }

    public static void validateNumberRange(List<Integer> numbers) {
        for (int number : numbers) {
            if (number < START_INCLUSIVE || number > END_INCLUSIVE) {
                throw new IllegalArgumentException(NUMBER_OUT_OF_RANGE_EXCEPTION + number);
            }
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
