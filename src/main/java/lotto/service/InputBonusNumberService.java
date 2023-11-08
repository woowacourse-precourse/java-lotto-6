package lotto.service;

import java.util.List;
import lotto.util.Validator;

public class InputBonusNumberService {

    public void checkRightBonusNumberInput(Validator validator, List<Integer> lottoWinNumbers,
        String bonusNumberInput) {
        validator.validateBonusNumberInput(bonusNumberInput);
        int convertedBonusNumber = Integer.parseInt(bonusNumberInput);
        validator.validateBonusNumberRange(convertedBonusNumber);
        validator.validateIsBonusNumberInWinnerNumber(lottoWinNumbers, convertedBonusNumber);
    }
}
