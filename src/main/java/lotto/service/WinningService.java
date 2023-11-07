package lotto.service;

import java.util.List;
import java.util.Objects;
import lotto.domain.Rank;
import lotto.domain.Lotto;
import lotto.domain.WinningNumber;
import lotto.domain.WinningResult;

public class WinningService {
    public WinningNumber createWinningNumber(List<Integer> numbers, int bonusNumber) {
        return new WinningNumber(numbers, bonusNumber);
    }

    public WinningResult calculateResults(List<Lotto> lottoTickets, WinningNumber winningNumber) {
        WinningResult winningResult = new WinningResult();
        lottoTickets.stream()
                .map(lottoTicket -> determineRank(lottoTicket, winningNumber))
                .filter(Objects::nonNull)
                .forEach(winningResult::addResult);
        return winningResult;
    }

    private Rank determineRank(Lotto lottoTicket, WinningNumber winningNumber) {
        int countOfMatch = lottoTicket.match(winningNumber);
        boolean hasBonusNumber = lottoTicket.hasBonusNumber(winningNumber);
        return Rank.getRank(countOfMatch, hasBonusNumber);
    }
}