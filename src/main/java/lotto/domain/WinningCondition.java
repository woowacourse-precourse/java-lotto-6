package lotto.domain;

import java.util.Map;

public class WinningCondition {

    private final Lotto winningLotto;
    private final int bonus;

    public WinningCondition(Lotto winningLotto, int bonus) {
        this.winningLotto = winningLotto;
        this.bonus = bonus;
    }

    public Map<Lotto, WinningRank> findWinningRankByLotto(LottoTickets lottoTickets) {
        return lottoTickets.findWinningRankByLotto(winningLotto, bonus);
    }
}
