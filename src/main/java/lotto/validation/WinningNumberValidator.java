package lotto.validation;

import java.util.Collections;
import java.util.List;
import lotto.domain.Number;

public class WinningNumberValidator {
    private static final String MULTIPLE_WINNING_NUMBER_DELIMITER = ",";

    private WinningNumberValidator() {
    }

    public static void validateWinningNumbers(String winningNumbers) {
        isMultiple(winningNumbers);
    }

    private static void isMultiple(String winningNumbers) {
        if (!winningNumbers.contains(MULTIPLE_WINNING_NUMBER_DELIMITER)) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 쉼표를 구분으로 입력해야 합니다.");
        }
    }

    public static void validateDuplicateWinningNumber(List<Number> winningNumbers) {
        if (isDuplicate(winningNumbers)) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 중복이 존재할 수 없습니다.");
        }
    }

    private static boolean isDuplicate(List<Number> winningNumbers) {
        return winningNumbers.stream()
            .anyMatch(winningNumber -> Collections.frequency(winningNumbers, winningNumber) > 1);
    }
}
