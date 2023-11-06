package lotto.domain.calculator;

import java.util.Arrays;
import java.util.List;

public class WinCalculator {
    private static List<Integer> winningNumber;
    private static Integer bonusNumber;

    public WinCalculator(List<Integer> winningNumber, Integer bonusNumber) {
        this.winningNumber = winningNumber;
        this.bonusNumber = bonusNumber;
    }

    public List<Integer> calculate(List<Integer> purchaseNumber) {
        int count = winningNumberCounter(purchaseNumber);
        int IsMatchedBonusNumber = 0; // false
        if(count == 5) {
            IsMatchedBonusNumber = bonusNumberCounter(purchaseNumber);
        }
        return Arrays.asList(count, IsMatchedBonusNumber);
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

    private static int bonusNumberCounter(List<Integer> purchaseNumber) {
        int number = 0;
        if(purchaseNumber.contains(bonusNumber)) {
            number =1;
        }
        return number;
    }
}
