package lotto.domain;

import java.util.List;

public class Winning {

    private Lotto winningLotto;
    private int bonusNumber;

    public Winning(List<Integer> winningNumbers, int bonusNumber) {
        this.winningLotto = new Lotto(winningNumbers);
        this.bonusNumber = bonusNumber;
    }

    public Lotto getWinningLotto() {
        return winningLotto;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
