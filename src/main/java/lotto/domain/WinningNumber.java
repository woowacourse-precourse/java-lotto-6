package lotto.domain;

import java.util.List;

public class WinningNumber {
    private Lotto lotto;

    public WinningNumber(Lotto lotto) {
        this.lotto = lotto;
    }

    public List<Integer> getWinningLotto() {
        return lotto.getLotto();
    }
}
