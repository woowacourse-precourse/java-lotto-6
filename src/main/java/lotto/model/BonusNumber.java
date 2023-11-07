package lotto.model;

import lotto.util.Validator;

import java.util.List;

public class BonusNumber {
    private final int bonusNumber;

    public BonusNumber(String bonusNumber, List<Integer> winningNumbers) {
        this.bonusNumber = validate(bonusNumber, winningNumbers);
    }

    private int validate(String bonusNumber, List<Integer> winningNumbers) {
        int intBonusNumber = Validator.isDigit(bonusNumber);
        Validator.outOfRange(intBonusNumber);
        Validator.duplicateNumber(winningNumbers, intBonusNumber);
        return intBonusNumber;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
