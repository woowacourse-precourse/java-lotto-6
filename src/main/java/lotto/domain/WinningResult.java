package lotto.domain;

import lotto.enums.Rank;

import java.util.Map;

public class WinningResult {
    private static final int INITIAL_NUMBER = 0;
    private final Map<Rank, Integer> winningResult;

    private WinningResult(LottoTickets lottoTickets, WinningLotto winningLotto) {
        winningResult = lottoTickets.calculateWinningResult(winningLotto);
    }

    public static WinningResult compare(LottoTickets lottoTickets, WinningLotto winningLotto) {
        return new WinningResult(lottoTickets, winningLotto);
    }

    public int getCount(Rank rank) {
        return winningResult.getOrDefault(rank, INITIAL_NUMBER);
    }

    public long calculateTotalAmount() {
        return winningResult.keySet().stream()
                .map(rank -> getCount(rank) * rank.getWinningAmount())
                .reduce(0L, Long::sum);
    }

    public Map<Rank, Integer> getWinningResult() {
        return this.winningResult;
    }
}
