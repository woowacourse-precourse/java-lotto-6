package lotto.domain;

import lotto.utils.Validator;
import java.util.List;

public class BonusNumber {
    private Integer bonusNumber;
    public BonusNumber(List<Integer> winningNumber, String bonusNumber) {
        Validator.checkBonusNumber(winningNumber, Integer.parseInt(bonusNumber));
        this.bonusNumber = Integer.parseInt(bonusNumber);
    }

    public Integer getBonusNumber() {
        return bonusNumber;
    }
}
