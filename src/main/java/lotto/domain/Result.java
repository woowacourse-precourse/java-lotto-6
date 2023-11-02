package lotto.domain;

import static lotto.constant.LottoConstant.MONEY_UNIT;

import java.util.Map;
import java.util.Map.Entry;
import lotto.constant.LottoConstant;
import lotto.constant.Rank;

public class Result {
    private final Map<Rank, Long> rankCount;

    private Result(Map<Rank, Long> rankCount) {
        this.rankCount = rankCount;
    }

    public static Result of(Map<Rank, Long> rankCount) {
        return new Result(rankCount);
    }

    public float calculateRate() {
        return (float) rankCount.entrySet()
                .stream()
                .mapToLong(Result::calculateEntryPrice)
                .sum() / getInputMoney() * 100;
    }

    private static long calculateEntryPrice(Entry<Rank, Long> entry) {
        return entry.getKey().getReward() * entry.getValue();
    }

    private float getInputMoney() {
        return rankCount.values()
                .stream()
                .mapToLong(count -> count)
                .sum() * MONEY_UNIT.getValue();
    }

    public Map<Rank, Long> getRankCount() {
        return rankCount;
    }
}
