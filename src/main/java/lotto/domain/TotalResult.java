package lotto.domain;

import java.util.EnumMap;
import lotto.enums.Reward;

public class TotalResult {
    private static final long SUM_INIT_VAL = 0L;

    private final EnumMap<Reward, Integer> totalResult;

    public TotalResult(EnumMap<Reward, Integer> totalResult) {
        this.totalResult = totalResult;
    }

    public EnumMap<Reward, Integer> getTotalResult() {
        return totalResult;
    }

    public long calcPrize() {
        long sum = SUM_INIT_VAL;

        for (Reward reward : totalResult.keySet()) {
            long rewardValue = reward.getReward();
            sum += rewardValue * totalResult.get(reward);
        }

        return sum;
    }
}
