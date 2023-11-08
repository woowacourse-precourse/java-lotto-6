package lotto.domain;

import java.util.EnumMap;
import lotto.enums.Reward;

public class TotalResult {
    private static final long SUM_INIT_VAL = 0L;
    private static final int MULTIPLE_VAL = 100;

    private final EnumMap<Reward, Integer> totalResult;

    public TotalResult(EnumMap<Reward, Integer> totalResult) {
        this.totalResult = totalResult;
    }

    public EnumMap<Reward, Integer> getTotalResult() {
        return totalResult;
    }

    public double calcRateOfReturn(int money) {
        long sum = SUM_INIT_VAL;

        for (Reward reward : totalResult.keySet()) {
            long rewardValue = reward.getReward();
            sum += rewardValue * totalResult.get(reward);
        }

        return (double) sum / money * MULTIPLE_VAL;
    }
}
