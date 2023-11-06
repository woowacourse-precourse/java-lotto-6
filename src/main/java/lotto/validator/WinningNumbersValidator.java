package lotto.validator;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WinningNumbersValidator {
    private static final int LENGTH = 6;
    private static final String ERROR_MESSAGE = "[ERROR] ";
    private static final int MIN_NUBMER = 1;
    private static final int MAX_NUBMER = 45;

    public static void validateLength(List<Integer> winningNumbers) {
        if (winningNumbers.size() != LENGTH) {
            throw new IllegalArgumentException(ERROR_MESSAGE + "6자리 숫자가 아닙니다.");
        }
    }

    public static void validateMinNumber(List<Integer> winningNumbers) {
        for (Integer number : winningNumbers) {
            if (number < MIN_NUBMER) {
                throw new IllegalArgumentException(ERROR_MESSAGE + "숫자는 1 이상입니다.");
            }
        }
    }

    public static void validateMaxNumber(List<Integer> winningNumbers) {
        for (Integer number : winningNumbers) {
            if (number > MAX_NUBMER) {
                throw new IllegalArgumentException(ERROR_MESSAGE + "숫자는 45 미만입니다.");
            }
        }
    }
    public static void validateDuplicateNumber(List<Integer> winningNumbers) {
        Set<Integer> winningNumbersElements = new HashSet<>(winningNumbers);
        if (winningNumbersElements.size() != winningNumbers.size()) {
            throw new IllegalArgumentException(ERROR_MESSAGE + "중복되는 숫자가 존재합니다.");
        }
    }
}
