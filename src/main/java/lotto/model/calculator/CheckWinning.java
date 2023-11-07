package lotto.model.calculator;

import java.util.List;
import java.util.Map;
import lotto.constant.BonusMatchType;
import lotto.constant.MatchNumber;

public class CheckWinning {
    private static List<Integer> winningNumber;
    private static Integer bonusNumber;

    public CheckWinning(List<Integer> winningNumber, Integer bonusNumber) {
        this.winningNumber = winningNumber;
        this.bonusNumber = bonusNumber;
    }

    public static Integer winningNumberCounter(List<Integer> purchaseNumber) {
        int count = 0;
        for(int i = 0; i < 6; i++) {
            if(purchaseNumber.contains(winningNumber.get(i))) {
                count++;
            }
        }
        return count;
    }

    public static BonusMatchType bonusNumberCounter(List<Integer> purchaseNumber) {
        BonusMatchType bonus = BonusMatchType.MISMATCH;
        if(purchaseNumber.contains(bonusNumber)) {
            bonus = BonusMatchType.MATCH;
        }
        return bonus;
    }
}
