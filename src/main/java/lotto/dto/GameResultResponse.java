package lotto.dto;

import java.util.Map;

public class GameResultResponse {
    private Map<Integer, Integer> totalReward;
    private double profit;

    public GameResultResponse(Map<Integer, Integer> totalReward, double profit) {
        this.totalReward = totalReward;
        this.profit = profit;
    }

    public Map<Integer, Integer> getTotalReward() {
        return totalReward;
    }

    public double getProfit() {
        return profit;
    }
}
