package domain;

import lotto.Validation;

import java.util.List;

public class BonusDraw {

    public void bonusDraw(List<Integer> winNumbers, String bonusNumberInput) {
        int bonusNumber = Validation.validateBonusNumberInRangeOrIsNumber(bonusNumberInput);
        Validation.validateBonusNumberByDuplicate(bonusNumber, winNumbers);
    }

    public int bonusNumber(String bonusNumberInput) {
        return Integer.parseInt(bonusNumberInput);
    }

}
