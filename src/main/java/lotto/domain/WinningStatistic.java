package lotto.domain;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class WinningStatistic {

    private final Map<Rank, Integer> result = new EnumMap<Rank, Integer>(Rank.class);

    public WinningStatistic(List<Rank> ranks) {
        ranks.forEach(rank -> result.put(rank, result.get(rank) + 1));
    }

    public Map<Rank, Integer> getResult() {
        return this.result;
    }

    public long calculateTotalWinningPrize() {
        return result.entrySet().stream()
                .mapToLong(entry -> (long) entry.getKey().getPrizeMoney() * entry.getValue())
                .sum();
    }
}