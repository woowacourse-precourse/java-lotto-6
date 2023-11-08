package lotto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
            System.out.println("[ERROR] 잘못된 형식의 번호입니다.");
            throw new IllegalArgumentException();
        }
    }
    public static void validateNotBlank(String input) {
        if (input.isEmpty()) {
            System.out.println("[ERROR] 공백이 삽입되었습니다.");
            throw new IllegalArgumentException();
        }
    }
    public static void validateUniqueNumbers(List<Integer> winningNumbers) {
        Set<Integer> uniqueNumbers = new HashSet<>(winningNumbers);
        if (uniqueNumbers.size() != winningNumbers.size()) {
            System.out.println("[ERROR] 당첨 번호는 중복될 수 없습니다.");
            throw new IllegalArgumentException();
        }
    }
    public static void validateNumberCount(List<Integer> numbers) {
        if (numbers.size() != 6) {
            System.out.println("[ERROR] 번호는 정확히 6개여야 합니다.");
            throw new IllegalArgumentException();
        }
    }

    public static void validateRange(int number) {
        if (number < 1 || number > 45) {
            System.out.println("[ERROR] 번호는 1과 45 사이어야 합니다.");
            throw new IllegalArgumentException();
        }
    }

    public static void validateBonusNumberNotInWinningNumbers(Lotto winningNumbers, int bonusNumber) {
        if (winningNumbers.isNumberInLotto(bonusNumber)) {
            System.out.println("[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다.");
            throw new IllegalArgumentException();
        }
    }
}
