package lotto.model;

import java.util.List;
import lotto.util.validator.BonusNumberValidator;

public class BonusNumber {

    public int inputBonusNumber(String input, List<Integer> winningNumbers) {
        BonusNumberValidator validator = BonusNumberValidator.createValidator();
        int number = validator.validate(input);
        validator.validateBonusNumber(winningNumbers, number);
        return number;
    }
}
