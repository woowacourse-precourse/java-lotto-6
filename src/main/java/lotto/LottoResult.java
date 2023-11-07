package lotto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class LottoResult {

    private final Map<Rank, Integer> result = new HashMap<>();

    public LottoResult() {
        for (Rank rank : Rank.values()) {
            result.put(rank, 0);
        }
    }

    public void putRank(final Rank rank) {
        result.put(rank, result.get(rank) + 1);
    }

    public long getTotalProfit() {
        long total = 0;
        for (Entry<Rank, Integer> entry : result.entrySet()) {
            Rank rank = entry.getKey();
            Integer count = entry.getValue();
            total += rank.prize() * count;
        }
        return total;
    }

    public void result(final Lottos lottos, final WinningLotto winningLotto) {
        List<Rank> matched = lottos.matched(winningLotto);
        matched.forEach(this::putRank);
    }

    public Map<Rank, Integer> getResult() {
        return result;
    }
}

