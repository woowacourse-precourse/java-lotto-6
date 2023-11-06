package lotto.service;

import java.util.HashSet;
import java.util.List;

import static lotto.exception.ExceptionMessage.lottoTicketInputExceptionMessage.*;

public class LottoValidateRegistry {
    public static void lottoTicketValidate (final List<Integer> userInput) {
        checkDuplicateNumbers(userInput);
        checkRangeOfNumbers(userInput);
        checkSizeOfNumbers(userInput);
    }

    private static void checkDuplicateNumbers (final List<Integer> userInput) {
        HashSet<Integer> set = new HashSet<>(userInput);
        if (set.size() != userInput.size()) {
            throw new IllegalArgumentException(INPUT_MUST_BE_UNIQUE.message);
        }
    }
    private static void checkRangeOfNumbers (final List<Integer> userInput) {
        for (int number : userInput) {
            if (number < 1 || number > 45) {
                throw new IllegalArgumentException(INPUT_MUST_BE_NUMERIC.message);
            }
        }
    }
    private static void checkSizeOfNumbers (final List<Integer> userInput) {
        if (userInput.size() != 6) {
            throw new IllegalArgumentException(INPUT_MUST_BE_6s.message);
        }
    }
}
