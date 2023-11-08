package lotto;

import java.util.List;

public class LotteryNumbers {
    final List<Integer> winningNumbers;
    final int bonusNumber;
    
    LotteryNumbers(List<Integer> winningNumbers, int bonusNumber) {
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }
}
