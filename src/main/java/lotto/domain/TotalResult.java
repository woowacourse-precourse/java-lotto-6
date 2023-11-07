package lotto.domain;

import java.util.EnumMap;
import lotto.enums.Reward;

public class TotalResult {
    private final EnumMap<Reward, Integer> totalResult;

    public TotalResult(EnumMap<Reward, Integer> totalResult) {
        this.totalResult = totalResult;
    }

    public EnumMap<Reward, Integer> getTotalResult() {
        return totalResult;
    }

    public double calcRateOfReturn(int money) {
        long sum = 0;

        for (Reward reward : totalResult.keySet()) {
            sum += reward.getReward() * totalResult.get(reward);
        }

        return (double) sum / money * 100;
    }
}
