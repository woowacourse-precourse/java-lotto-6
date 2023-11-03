package lotto.domain;

import java.util.Map;

public class WinningCondition {

    private final Lotto winningLotto;
    private final int bonus;

    public WinningCondition(Lotto winningLotto, int bonus) {
        this.winningLotto = winningLotto;
        this.bonus = bonus;
    }

    public Map<Lotto, WinningRank> findWinningResult(LottoTickets lottoTickets) {
        return lottoTickets.findWinningResult(winningLotto, bonus);
    }
}
