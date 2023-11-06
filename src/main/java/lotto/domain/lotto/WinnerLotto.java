package lotto.domain.lotto;

import java.util.Collections;
import java.util.List;

public class WinnerLotto {

    private final List<Integer> winnerLotto;
    int bonusNumber;

    public WinnerLotto(List<Integer> winnerLotto, int bonusNumber) {
        Collections.sort(winnerLotto);
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
