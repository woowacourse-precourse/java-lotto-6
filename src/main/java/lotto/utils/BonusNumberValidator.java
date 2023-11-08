package lotto.utils;

import lotto.model.Lotto;

public class BonusNumberValidator {
    public static void validIsInt(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 숫자여야 합니다.");
        }
    }

    public static void validIsNotDuplicateWithWinningNumbers(int bonusNumber, Lotto winningNumbers) {
        if (winningNumbers.getNumbers().contains(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨 번호와 겹치면 안됩니다.");
        }
    }
}
