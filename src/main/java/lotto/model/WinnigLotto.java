package lotto.model;

import java.util.Set;

public class WinnigLotto {
    private final Set<Integer> winningNumbers;
    private final Integer bonusNumber;

    public WinnigLotto(Set<Integer> winningNumbers, Integer bonusNumber) {
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    public NumberStatus judgeNumber(Integer number) {
        if (winningNumbers.contains(number)) {
            return NumberStatus.CORRECT;
        }
        if (bonusNumber.equals(number)) {
            return NumberStatus.BONUS;
        }
        return NumberStatus.NOTHING;
    }
}
