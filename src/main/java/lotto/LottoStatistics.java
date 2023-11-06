package lotto;

import java.util.Map;
import java.util.HashMap;
import java.util.List;

public class LottoStatistics {
    private Map<Rank, Integer> results;

    LottoStatistics(List<Lotto> tickets, Lotto userLotto, int bonusNumber) {
        results = new HashMap<>();
        setResults(tickets, userLotto, bonusNumber);
    }

    private void setResults(List<Lotto> tickets, Lotto userLotto, int bonusNumber) {
        for (Lotto lotto : tickets) {
            Rank rank = userLotto.compare(lotto, bonusNumber);
            if (rank != Rank.LOSE) {
                results.put(rank, results.getOrDefault(rank, 0) + 1);
            }
        }
    }
}
