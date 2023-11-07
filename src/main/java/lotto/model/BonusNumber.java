package lotto.model;

import java.util.List;
import lotto.controller.Validation;

public class BonusNumber {
    private final int bonusNumber;

    public BonusNumber(int bonusNumber, List<Integer> winningNumbers) {
        validate(bonusNumber, winningNumbers);
        this.bonusNumber = bonusNumber;
    }

    private void validate(int bonusNumber, List<Integer> winnginNumbers) {
        Validation.validateBonusNumberRange(bonusNumber);
        Validation.validateBonusNumberDuplication(bonusNumber, winnginNumbers);
    }

    public int bonusNumber() {
        return this.bonusNumber;
    }
}
