package lotto.domain.lotto;

import java.util.List;

public class WinnerLotto {

    private final List<Integer> winnerLotto;
    int bonusNumber;

    public WinnerLotto(List<Integer> winnerLotto, int bonusNumber) {
        this.winnerLotto = winnerLotto;
        this.bonusNumber = bonusNumber;
    }

    public List<Integer> getWinnerLotto() {
        return winnerLotto;
    }

    public int getBonusNUmber() {
        return bonusNumber;
    }
}
