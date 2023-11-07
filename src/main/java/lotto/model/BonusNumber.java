package lotto.model;

import lotto.util.CommonValidation;
import lotto.util.Constants;
import lotto.util.LottoValidation;
import java.util.List;

public class BonusNumber {
    private final int bonusNumber;
    private BonusNumber(int bonusNumber) {
        this.bonusNumber = bonusNumber;
    }
    public static BonusNumber bonusNumberOf(List<Integer> lotto, String bonusNumber) {
        CommonValidation.validate(bonusNumber);
        LottoValidation.isPermitRange(Integer.parseInt(bonusNumber), Constants.Format.BONUS_NUMBER.getType());
        LottoValidation.duplicationLottoAndBonusNumber(lotto,bonusNumber);
        return new BonusNumber(Integer.parseInt(bonusNumber));
    }
    public int getBonusNumber() {
        return this.bonusNumber;
    }
}
