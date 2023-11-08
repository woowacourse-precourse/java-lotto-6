package lotto;

import java.util.List;

public class LotteryNumbers {
    private final List<Integer> winningNumbers;
    private final int bonusNumber;
    
    LotteryNumbers(List<Integer> winningNumbers, int bonusNumber) {
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }
}
