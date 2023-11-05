package lotto.domain;

import java.util.List;

public class WinningCalculator {
    private static List<Integer> winningNumber;
    private static Integer bonusNumber;
    WinningRecord winningRecord = new WinningRecord();

    public WinningCalculator(List<Integer> winningNumber, Integer bonusNumber) {
        this.winningNumber = winningNumber;
        this.bonusNumber = bonusNumber;
    }

    public void calculator(List<Integer> purchaseNumber) {
        int count = winningNumberCounter(purchaseNumber);
        boolean IsMatchedBonusNumber = false;
        if(count == 5) {
            IsMatchedBonusNumber = bonusNumberCounter(purchaseNumber);
        }
        winningRecord.recorder(count, IsMatchedBonusNumber);
    }

    private static Integer winningNumberCounter(List<Integer> purchaseNumber) {
        int count = 0;
        for(int i = 0; i < 6; i++) {
            if(purchaseNumber.contains(winningNumber.get(i))) {
                count++;
            };
        }
        return count;
    }

    private static boolean bonusNumberCounter(List<Integer> purchaseNumber) {
        return purchaseNumber.contains(bonusNumber);
    }
}
