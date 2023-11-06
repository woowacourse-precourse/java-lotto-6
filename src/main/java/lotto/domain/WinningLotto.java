package lotto.domain;

import java.util.List;

public class WinningLotto {

    private final Lotto winningLotto;

    public WinningLotto(List<Integer> winnings) {
        this.winningLotto = Lotto.from(winnings);
    }

    public static WinningLotto createWinningLottos(List<Integer> winnings) {
        return new WinningLotto(winnings);
    }

    public List<Integer> getLotto() {
        return winningLotto.getLotto();
    }

}
