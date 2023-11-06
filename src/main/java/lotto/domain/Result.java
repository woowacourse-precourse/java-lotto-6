package lotto.domain;

import java.util.List;
import lotto.constant.PrizeConstant;

public class Result {
    private final static int PERCENT = 10;
    private final List<Integer> statistics;
    private final int totalReward;

    public Result(List<Integer> statistics) {
        this.statistics = statistics;
        this.totalReward = getTotalReward();
    }

    public List<Integer> getStatistics() {
        return statistics;
    }

    public float getProfitability(int quantity) {
        return (float)totalReward / (quantity * PERCENT);
    }

    private int getTotalReward() {
        int totalReward = 0;
        for (int i = 0; i < statistics.size(); i++) {
            int reward = PrizeConstant.getRewardByScore(i);
            int count = statistics.get(i);
            totalReward += (reward * count);
        }
        return totalReward;
    }

}
