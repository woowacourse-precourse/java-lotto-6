package lotto.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoResult {
    private final List<Lotto> lottos;

    public LottoResult(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public Map<Rank, Integer> checkResult(WinningLotto winningLotto) {
        Map<Rank, Integer> result = new HashMap<>();
        for (Lotto lotto : lottos) {
            Rank rank = Rank.getRankByLotto(lotto, winningLotto);
            result.put(rank, result.getOrDefault(rank, 0) + 1);
        }
        return result;
    }
}
