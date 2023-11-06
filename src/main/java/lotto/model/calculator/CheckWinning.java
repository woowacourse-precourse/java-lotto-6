package lotto.model.calculator;

import java.util.List;
import java.util.Map;

public class CheckWinning {
    private static List<Integer> winningNumber;
    private static Integer bonusNumber;

    public CheckWinning(List<Integer> winningNumber, Integer bonusNumber) {
        this.winningNumber = winningNumber;
        this.bonusNumber = bonusNumber;
    }

    public Map<String, Integer> calculate(List<Integer> purchaseNumber) {
        int count = winningNumberCounter(purchaseNumber);
        int isMatchedBonusNumber = 0; // false
        if(count == 5) {
            isMatchedBonusNumber = bonusNumberCounter(purchaseNumber);
        }
        Map<String, Integer> result = Map.of(
                "matchedNumberCount", count,
                "isMatchedBonusNumber", isMatchedBonusNumber
        );
        return result;
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
