package lotto.validator;

import java.util.List;

public class InputWinningBonusNumberValidator {
    public static void validateOnlyPositiveNumberBonus(String numbersString) {
        if (!numbersString.matches("\\d+")) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 숫자로만 입력되어야 합니다.");
        }
    }


    public static void validateBonusNumberRange(int winningBonusNumber) {
        if (winningBonusNumber < 1 || winningBonusNumber > 45) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
    }

    public static void validateWinningBonusNumberAlreadyExists(int winningBonusNumber, List<Integer> winningNumbers) {
        if (winningNumbers.contains(winningBonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호가 이미 당첨 번호에 존재합니다.");
        }
    }
}
