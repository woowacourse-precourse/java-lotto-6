package lotto.domain;

import java.util.Map;

public class WinningCondition {

    private final Lotto winningLotto;
    private final int bonusNumber;

    public WinningCondition(Lotto winningLotto, int bonusNumber) {
        this.winningLotto = winningLotto;
        this.bonusNumber = bonusNumber;
    }

    public Map<Lotto, Rank> findRankByLotto(LottoTickets lottoTickets) {
        return lottoTickets.findRankByLotto(winningLotto, bonusNumber);
    }
}
