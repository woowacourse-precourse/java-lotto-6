package lotto.input;


import java.util.Set;

import static lotto.output.Constants.NumbersValidatorConstants.*;

public class NumbersValidator {
    protected static int validateNumberFormat(String number) {
        try {
            return Integer.parseInt(number);
        } catch (NumberFormatException e) {
            System.out.println();
            throw new IllegalArgumentException(FORMAT_ERROR_MESSAGE);
        }
    }

    protected static void validateNumberRange(int number) {
        if (number < 1 || number > 45) {
            System.out.println();
            throw new IllegalArgumentException(RANGE_ERROR_MESSAGE);
        }
    }

    protected static void validateDuplicate(int number, Set<Integer> winningNumbers) {
        if (!winningNumbers.add(number)) {
            System.out.println();
            throw new IllegalArgumentException(DUPLICATE_ERROR_MESSAGE);
        }
    }
}
