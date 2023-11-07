package domain;

import lotto.Validation;

import java.util.List;

public class BonusDraw {

//    /* 보너스번호 validation 시작 */
//    int bonusNumber = validation.validateBonusNumberInRangeOrIsNumber(bonusNumberInput);
//            validation.validateBonusNumberByDuplicate(bonusNumber, winNumbers);
//    /* 보너스번호 validation 종료 */

    public void bonusDraw(List<Integer> winNumbers, String bonusNumberInput) {
        int bonusNumber = Validation.validateBonusNumberInRangeOrIsNumber(bonusNumberInput);
        Validation.validateBonusNumberByDuplicate(bonusNumber, winNumbers);
    }

}
