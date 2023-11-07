package lotto;

import java.util.HashMap;
import java.util.Map;

public class Result {
    private final Map<Rank, Integer> result = new HashMap<>();

    public void addResult(LottoCompareResult compareResult) {
        Rank rank = Rank.valueOf(compareResult.matchCount(), compareResult.matchBonus());
        result.put(rank, result.getOrDefault(rank, 0) + 1);
    }

    public int getCount(Rank rank) {
        return result.getOrDefault(rank, 0);
    }

    public int getTotalWinningMoney() {
        return result.entrySet().stream()
                .mapToInt(entry -> entry.getKey().getWinningMoney() * entry.getValue())
                .sum();
    }

    public Map<Rank, Integer> getResult() {
        return result;
    }
}
