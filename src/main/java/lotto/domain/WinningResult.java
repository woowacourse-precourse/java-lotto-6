package lotto.domain;

import lotto.enums.Rank;

import java.util.EnumMap;
import java.util.Map;

public class WinningResult {
    private static final int INITIAL_NUMBER = 0;
    private final Map<Rank, Integer> winningResult;

    public WinningResult(LottoTickets lottoTickets, WinningLotto winningLotto) {
        winningResult = new EnumMap<>(Rank.class);

        for (Lotto lotto : lottoTickets.getLottoTickets()) {
            Rank rank = winningLotto.match(lotto);
            if(rank == null) continue;
            winningResult.put(rank, winningResult.getOrDefault(rank, 0) + 1);
        }
    }

    public int getCount(Rank rank) {
        if(winningResult.get(rank) == null) {
            return INITIAL_NUMBER;
        }
        return winningResult.get(rank);
    }
}
