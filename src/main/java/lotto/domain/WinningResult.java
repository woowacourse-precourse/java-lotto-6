package lotto.domain;

import lotto.enums.Rank;

import java.util.EnumMap;
import java.util.Map;

public class WinningResult {
    private static final int INITIAL_NUMBER = 0;
    private static final int COUNT_NUMBER = 1;
    private final Map<Rank, Integer> winningResult;

    private WinningResult(LottoTickets lottoTickets, WinningLotto winningLotto) {
        winningResult = new EnumMap<>(Rank.class);
        calculateWinningResult(lottoTickets, winningLotto);
    }

    public static WinningResult compare (LottoTickets lottoTickets, WinningLotto winningLotto) {
        return new WinningResult(lottoTickets, winningLotto);
    }

    public int getCount(Rank rank) {
        return winningResult.getOrDefault(rank, INITIAL_NUMBER);
    }

    public int calculateTotalAmount() {
        return winningResult.keySet().stream()
                .map(rank -> getCount(rank) * rank.getWinningAmount())
                .reduce(INITIAL_NUMBER, Integer::sum);
    }

    public Map<Rank, Integer> getWinningResult() {
        return this.winningResult;
    }

    private void calculateWinningResult(LottoTickets lottoTickets, WinningLotto winningLotto) {
        for (Lotto lotto : lottoTickets.getLottoTickets()) {
            Rank rank = winningLotto.match(lotto);
            if (rank == null) continue;
            winningResult.put(rank, winningResult.getOrDefault(rank, INITIAL_NUMBER) + COUNT_NUMBER);
        }
    }
}
