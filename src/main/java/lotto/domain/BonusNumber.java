package lotto.domain;

import java.util.List;

public class BonusNumber extends Validation {
    private final int bonusNumber;

    public BonusNumber(String number, List<Integer> winningNumbers) {
        this.bonusNumber = validateBonusNumber(number, winningNumbers);
    }

    private int validateBonusNumber(String number, List<Integer> winningNumbers) {
        checkValidInteger(number);
        checkDuplicateWithWinningNumber(number, winningNumbers);
        checkNumberRange(number);

        return Integer.parseInt(number);
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
