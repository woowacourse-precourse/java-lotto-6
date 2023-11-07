package lotto.constant;

import lotto.model.LotteryResult;

import java.util.AbstractMap;
import java.util.Map;

public enum LotteryRank {
    FIRST_PRIZE(2_000_000_000L),
    SECOND_PRIZE(30_000_000L),
    THIRD_PRIZE(1_500_000L),
    FOURTH_PRIZE(50_000L),
    FIFTH_PRIZE(5_000L),
    ETC(0L);

    private final Long reward;

    LotteryRank(Long reward) {
        this.reward = reward;
    }

    private static final Map<LotteryResult, LotteryRank> winningCriteria = Map.ofEntries(
            new AbstractMap.SimpleEntry<>(new LotteryResult(6, false), FIRST_PRIZE),
            new AbstractMap.SimpleEntry<>(new LotteryResult(5, true), SECOND_PRIZE),
            new AbstractMap.SimpleEntry<>(new LotteryResult(5, false), THIRD_PRIZE),
            new AbstractMap.SimpleEntry<>(new LotteryResult(4, false), FOURTH_PRIZE),
            new AbstractMap.SimpleEntry<>(new LotteryResult(3, false), FIFTH_PRIZE)
    );

    public Long getReward() {
        return reward;
    }

    public static LotteryRank getLotteryRank(LotteryResult lotteryResult) {
        return winningCriteria.getOrDefault(lotteryResult, ETC);
    }
}
