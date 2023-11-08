package lotto.validator;

import java.util.List;

public class InputWinningNumbersValidator {
    public static void validateOnlyPositiveWinningNumbers(String numbersString) {
        if (!numbersString.matches("^(\\d+(,\\d+)+)$")) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 공백을 제외한 정수와 쉼표(,)로만 입력되어야 합니다.");
        }
    }

    public static void validateWinningNumbers(List<Integer> winningNumbers) {
        validateWinningNumbersSize(winningNumbers);
        validateWinningNumberRange(winningNumbers);
        validateWinningNumberDuplicate(winningNumbers);
    }

    private static void validateWinningNumbersSize(List<Integer> winningNumbers) {
        if (winningNumbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개가 입력되어야 합니다.");
        }
    }

    private static void validateWinningNumberRange(List<Integer> winningNumbers) {
        if (winningNumbers.stream().anyMatch(number -> number <= 0 || number > 45)) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
    }

    private static void validateWinningNumberDuplicate(List<Integer> winningNumbers) {
        if (winningNumbers.stream().distinct().count() != winningNumbers.size()) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 중복이 될 수 없습니다.");
        }
    }
}
