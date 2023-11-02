package lotto.domain;

import java.util.Map;
import java.util.Map.Entry;
import lotto.constant.Rank;

public class Result {
    private final Map<Rank, Long> rankCount;

    private Result(Map<Rank, Long> rankCount) {
        this.rankCount = rankCount;
    }

    public static Result of(Map<Rank, Long> rankCount) {
        return new Result(rankCount);
    }

    public float calculateRate(int money) {
        return (float) rankCount.entrySet()
                .stream()
                .mapToLong(Result::calculateEntryPrice)
                .sum() / money;
    }

    private static long calculateEntryPrice(Entry<Rank, Long> entry) {
        return entry.getKey().getReward() * entry.getValue();
    }
}
