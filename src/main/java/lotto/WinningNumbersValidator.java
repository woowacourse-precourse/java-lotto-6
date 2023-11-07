package lotto;

import java.util.List;

public class WinningNumbersValidator {
    public static void validateWinningNumbers(List<Integer> winningNumbers) {
        validateNumberCount(winningNumbers);
        for (int number : winningNumbers) {
            validateRange(number);
        }
    }
    public static int validateNumberAndReturnInt(String numberStr) {
        String trimmedNumberStr = numberStr.trim();
        validateNotBlank(trimmedNumberStr);
        try {
            return Integer.parseInt(trimmedNumberStr);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("잘못된 형식의 번호입니다.");
        }
    }
    public static void validateNotBlank(String input) {
        if (input.isEmpty()) {
            throw new IllegalArgumentException("공백이 삽입되었습니다.");
        }
    }
    public static void validateNumberCount(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("번호는 정확히 6개여야 합니다.");
        }
    }

    public static void validateRange(int number) {
        if (number < 1 || number > 45) {
            throw new IllegalArgumentException("번호는 1과 45 사이어야 합니다: " + number);
        }
    }

    public static void validateBonusNumberNotInWinningNumbers(Lotto winningNumbers, int bonusNumber) {
        if (winningNumbers.isNumberInLotto(bonusNumber)) {
            throw new IllegalArgumentException("보너스 번호는 당첨 번호와 중복될 수 없습니다.");
        }
    }
}
