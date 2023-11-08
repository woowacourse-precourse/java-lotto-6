package lotto.Domain;

import lotto.Validator.Validator;

import java.util.List;

public class BonusNumber {
    private final int bonusNumber;
    public BonusNumber(int bonusNumber, List<Integer> winningNumbers) {
        Validator.validateNumberRange(bonusNumber);
        Validator.validateContainWinningNumbers(winningNumbers, bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    public int getBonusNumber() {
        return this.bonusNumber;
    }
}
