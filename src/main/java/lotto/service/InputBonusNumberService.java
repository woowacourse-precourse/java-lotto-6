package lotto.service;

import lotto.util.Validator;

public class InputBonusNumberService {

    public void checkRightBonusNumberInput(Validator validator, String bonusNumberInput) {
            validator.validateBonusNumberInput(bonusNumberInput);
            int convertedBonusNumber = Integer.parseInt(bonusNumberInput);
            validator.validateBonusNumberRange(convertedBonusNumber);
    }
}
