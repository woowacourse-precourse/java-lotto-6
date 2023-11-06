package lotto.domain.winningnumbers;

import lotto.domain.lotto.Lotto;
import java.util.List;

public class WinningNumbers {

    private final Lotto winningNumbers;
    private final BonusNumber bonusNumber;

    public WinningNumbers(List<Integer> winningNumbers, int bonusNumber) {
        this.winningNumbers = new Lotto(winningNumbers);
        this.bonusNumber = new BonusNumber(winningNumbers,bonusNumber);
    }

    public boolean isInWinningNumbers(int number) {
        return winningNumbers.getNumbers()
                .contains(number);
    }

    public boolean isSameWithBonusNumber(int number) {
        return bonusNumber.isBonusNumber(number);
    }

}
