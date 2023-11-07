package lotto.model;

import java.util.List;
import lotto.util.validator.BonusNumberValidator;

public class BonusNumber {

    private int bonusNumber;

    public void inputBonusNumber(String input, List<Integer> winningNumbers) {
        BonusNumberValidator validator = BonusNumberValidator.createValidator();
        int number = validator.validate(input);
        validator.validateBonusNumber(winningNumbers, number);
        this.bonusNumber = number;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
