package lotto.domain.winningnumbers;

import lotto.domain.lotto.Lotto;

import java.util.List;

public class WinningNumbers {

    private final Lotto lotto;
    private final BonusNumber bonusNumber;

    public WinningNumbers(List<Integer> winningNumbers, int bonusNumber) {
        this.lotto = new Lotto(winningNumbers);
        this.bonusNumber = new BonusNumber(winningNumbers,bonusNumber);
    }

}
