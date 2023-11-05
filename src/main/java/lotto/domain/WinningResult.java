package lotto.domain;

import java.util.HashMap;
import java.util.Map;

public class WinningResult {
    private final Map<String, Integer> winningResult;

    public WinningResult(LottoTickets lottoTickets, WinningLotto winningLotto) {
        winningResult = new HashMap<>();

        for(Lotto lotto : lottoTickets.getLottoTickets()) {
            winningResult.put(winningLotto.match(lotto), winningResult.getOrDefault(winningLotto.match(lotto),0) + 1);
        }
    }

    public int getCount(String rank) {
        return winningResult.get(rank);
    }
}
