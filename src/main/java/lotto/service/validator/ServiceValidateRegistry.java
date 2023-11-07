package lotto.service.validator;

import java.util.HashSet;
import java.util.List;

import static lotto.exception.ExceptionMessage.*;

public class ServiceValidateRegistry {
    protected static void checkDuplicateNumbers (final List<Integer> userInput) {
        HashSet<Integer> set = new HashSet<>(userInput);
        if (set.size() != userInput.size()) {
            throw new IllegalArgumentException(INPUT_MUST_BE_UNIQUE.message);
        }
    }
    protected static void checkRangeOfNumbers (final List<Integer> userInput) {
        for (int number : userInput) {
            if (number < 1 || number > 45) {
                throw new IllegalArgumentException(INPUT_MUST_BE_NUMERIC.message);
            }
        }
    }
    protected static void checkSizeOfNumbers (final List<Integer> userInput) {
        if (userInput.size() != 6) {
            throw new IllegalArgumentException(INPUT_MUST_BE_6s.message);
        }
    }

    protected static void winningNumberSizeValidate(List<Integer> numbers) {
        if (numbers.size() != 7) { // 로또 번호는 6개, 보너스 번호 1개로 총 7개
            throw new IllegalArgumentException("로또 번호와 보너스 번호의 총 개수는 7개여야 합니다.");
        }
    }

    protected static void validateAmountIn1000s(final String userInput) {
        if (Integer.parseInt(userInput) % 1000 != 0) {
            throw new IllegalArgumentException(INPUT_MUST_BE_1000s.message);
        }
    }
}
