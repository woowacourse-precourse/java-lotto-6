package lotto.domain;

import java.util.List;

public class LotteryMachine {
    private final List<Integer> winningNumber;
    private final int bonusNumber;
    private Lotto lotto;

    public LotteryMachine(List<Integer> winningNumber, int bonusNumber) {
        this.winningNumber = winningNumber;
        this.bonusNumber = bonusNumber;
    }

    public int check(Lotto lotto) {
        this.lotto = lotto;
        int count = 0;
        for (Integer number : winningNumber) {
            if (lotto.contains(number)) {
                count++;
            }
        }
        return count;
    }

    public boolean checkBonus() {
        return lotto.contains(bonusNumber);
    }
}
