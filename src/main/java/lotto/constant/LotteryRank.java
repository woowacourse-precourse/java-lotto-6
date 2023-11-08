package lotto.constant;

import lotto.model.LotteryResult;

import java.util.AbstractMap;
import java.util.Map;

public enum LotteryRank {
    FIRST_PRIZE(2_000_000_000L, "6개 일치 (2,000,000,000원)"),
    SECOND_PRIZE(30_000_000L, "5개 일치, 보너스 볼 일치 (30,000,000원)"),
    THIRD_PRIZE(1_500_000L, "5개 일치 (1,500,000원)"),
    FOURTH_PRIZE(50_000L, "4개 일치 (50,000원)"),
    FIFTH_PRIZE(5_000L, "3개 일치 (5,000원)"),
    ETC(0L, "꽝");

    private final Long reward;
    private final String message;

    LotteryRank(Long reward, String message) {
        this.reward = reward;
        this.message = message;
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

    public String getMessage() {
        return message;
    }

    public static LotteryRank getLotteryRank(LotteryResult lotteryResult) {
        return winningCriteria.getOrDefault(lotteryResult, ETC);
    }
}
