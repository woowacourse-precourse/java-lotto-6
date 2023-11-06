package lotto.domain;

import static lotto.constant.LottoConstant.MONEY_UNIT;

import java.util.Collections;
import java.util.Map;
import java.util.Map.Entry;
import lotto.constant.Rank;

public class Result {

    private static final float HUNDRED = 100.0F;

    private final Map<Rank, Long> rankCount;

    private Result(final Map<Rank, Long> rankCount) {
        this.rankCount = rankCount;
    }

    public static Result from(final Map<Rank, Long> rankCount) {
        return new Result(rankCount);
    }

    public float calculateRateToReturn() {
        return calculateTotalPrice() / calculateInputMoney() * HUNDRED;
    }

    private long calculateTotalPrice() {
        return rankCount.entrySet()
                .stream()
                .mapToLong(this::calculateEntryPrice)
                .sum();
    }

    private long calculateEntryPrice(final Entry<Rank, Long> entry) {
        return entry.getKey().getReward() * entry.getValue();
    }

    private float calculateInputMoney() {
        return rankCount.values()
                .stream()
                .mapToLong(count -> count)
                .sum() * MONEY_UNIT.getValue();
    }

    public Map<Rank, Long> getRankCount() {
        return Collections.unmodifiableMap(rankCount);
    }
}
