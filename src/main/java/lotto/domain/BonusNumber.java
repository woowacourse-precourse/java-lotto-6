package lotto.domain;

import java.util.List;
import lotto.validator.BonusNumberValidator;

public class BonusNumber {
    private final int bonusNumber;

    public BonusNumber(int bonusNumber, List<Integer> winningNumbers) {
        BonusNumberValidator.hasDuplicateNumber(bonusNumber, winningNumbers);
        BonusNumberValidator.validateMinNumber(bonusNumber);
        BonusNumberValidator.validateMaxNumber(bonusNumber);
        this.bonusNumber = bonusNumber;
    }
}
