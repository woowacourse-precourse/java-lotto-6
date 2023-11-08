package lotto.validator;

import static lotto.util.Constants.MAX_NUMBER;
import static lotto.util.Constants.MIN_NUMBER;

import java.util.Set;

public class BonusNumberValidator {
    public static int validateBonusNumber(String input, Set<Integer> winningNumbers) {
        int bonusNumber = validateNumericInput(input);
        validateNumberRange(bonusNumber);
        validateDuplicateNumber(bonusNumber, winningNumbers);
        return bonusNumber;
    }

    private static void validateNumberRange(int number) {
        if (number < MIN_NUMBER || number > MAX_NUMBER) {
            throw new IllegalArgumentException("[ERROR] 1부터 45 사이의 숫자를 입력해 주세요.");
        }
    }

    private static void validateDuplicateNumber(int number, Set<Integer> winningNumbers) {
        if (winningNumbers.contains(number)) {
            throw new IllegalArgumentException("[ERROR] 이미 당첨 번호로 선택된 숫자입니다.");
        }
    }

    private static int validateNumericInput(String input) {
        if (!input.matches("\\d+")) {
            throw new IllegalArgumentException("[ERROR] 숫자만 입력해 주세요.");
        }
        return Integer.parseInt(input);
    }
}
