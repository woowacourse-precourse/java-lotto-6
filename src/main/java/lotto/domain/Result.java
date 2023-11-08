package lotto.domain;

import static lotto.constant.LottoConstant.MAX_SCORE;
import static lotto.constant.LottoConstant.MIN_SCORE;

import java.util.List;
import lotto.constant.PrizeConstant;

public class Result {
    private static final int PERCENT = 10;
    private static final int MIN_REWARD = 0;
    private final List<Integer> statistics;
    private final int totalReward;

    public Result(List<Integer> statistics) {
        this.statistics = statistics;
        this.totalReward = getTotalReward();
    }

    public double getProfitability(int quantity) {
        return (double)totalReward / (quantity * PERCENT);
    }

    private int getTotalReward() {
        int totalReward = MIN_REWARD;

        for (int score = MIN_SCORE.getValue(); score <= MAX_SCORE.getValue(); score++) {
            int reward = PrizeConstant.getRewardByScore(score);
            int count = statistics.get(score);
            totalReward += (reward * count);
        }

        return totalReward;
    }

}
