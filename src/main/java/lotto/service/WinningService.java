package lotto.service;

import java.util.List;
import java.util.Objects;
import lotto.domain.Rank;
import lotto.domain.Lotto;
import lotto.domain.WinningLotto;
import lotto.domain.WinningResult;

public class WinningService {
    public WinningLotto createWinningNumber(List<Integer> winningNumbers, int bonusNumber) {
        return new WinningLotto(winningNumbers, bonusNumber);
    }

    public WinningResult calculateResults(List<Lotto> lottoTickets, WinningLotto winningLotto) {
        WinningResult winningResult = new WinningResult();
        lottoTickets.stream()
                .map(lottoTicket -> determineRank(lottoTicket, winningLotto))
                .filter(Objects::nonNull)
                .forEach(winningResult::addResult);
        return winningResult;
    }

    private Rank determineRank(Lotto lottoTicket, WinningLotto winningLotto) {
        int countOfMatch = lottoTicket.match(winningLotto);
        boolean hasBonusNumber = lottoTicket.hasBonusNumber(winningLotto);
        return Rank.getRank(countOfMatch, hasBonusNumber);
    }
}