package lotto.dto;

import java.util.Map;

public class GameResultResponse {
    private Map<Integer, Integer> totalReward;
    private String profit;

    public GameResultResponse(Map<Integer, Integer> totalReward, String profit) {
        this.totalReward = totalReward;
        this.profit = profit;
    }

    public Map<Integer, Integer> getTotalReward() {
        return totalReward;
    }

    public String getProfit() {
        return profit;
    }
}
