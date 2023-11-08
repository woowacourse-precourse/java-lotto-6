package lotto.model.calculator;

import java.util.List;
import lotto.constant.BonusMatchType;
import lotto.constant.UnitNumber;

public class CheckWinning {
    private static List<Integer> winningNumber;
    private static Integer bonusNumber;

    public CheckWinning(List<Integer> winningNumber, Integer bonusNumber) {
        this.winningNumber = winningNumber;
        this.bonusNumber = bonusNumber;
    }

    public Integer winningNumberCounter(List<Integer> purchaseNumber) {
        int count = UnitNumber.ZERO.getNumber();
        for(int i = UnitNumber.ZERO.getNumber(); i < UnitNumber.WINNING_COUNT.getNumber(); i++) {
            if(purchaseNumber.contains(winningNumber.get(i))) {
                count++;
            }
        }
        return count;
    }

    public BonusMatchType bonusNumberCounter(List<Integer> purchaseNumber) {
        BonusMatchType bonus = BonusMatchType.MISMATCH;
        if(purchaseNumber.contains(bonusNumber)) {
            bonus = BonusMatchType.MATCH;
        }
        return bonus;
    }
}
