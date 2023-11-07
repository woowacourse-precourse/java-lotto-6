package lotto.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lotto.dto.LottoCompareResult;

public class Result {
    private final Map<Rank, Integer> result = new HashMap<>();

    private void addResult(LottoCompareResult compareResult) {
        Rank rank = Rank.valueOf(compareResult.matchCount(), compareResult.matchBonus());
        result.put(rank, result.getOrDefault(rank, 0) + 1);
    }

    public int getCount(Rank rank) {
        return result.getOrDefault(rank, 0);
    }

    public long getTotalWinningMoney(List<LottoCompareResult> compareResultList) {
        for (LottoCompareResult compareResult : compareResultList) {
            addResult(compareResult);
        }
        return result.entrySet().stream()
                .mapToLong(entry -> entry.getKey().getWinningMoney() * entry.getValue())
                .sum();
    }

    public Map<Rank, Integer> getResult() {
        return result;
    }
}
