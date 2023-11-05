package lotto.domain;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class WinningStatistic {

    private final Map<Rank, Integer> result = new EnumMap<Rank, Integer>(Rank.class);

    public WinningStatistic(List<Rank> ranks) {
        for (Rank rank : Rank.values()) {
            result.put(rank, 0);
        }
        ranks.forEach(rank -> result.put(rank, result.getOrDefault(rank, 0) + 1));
    }

    public Map<Rank, Integer> getResult() {
        return this.result;
    }

    public long calculateTotalPrize() {
        return result.entrySet().stream()
                .mapToLong(entry -> entry.getKey().multiplePrizeAndCount(entry.getValue()))
                .sum();
    }
}