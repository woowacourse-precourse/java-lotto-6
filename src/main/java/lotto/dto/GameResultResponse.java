package lotto.dto;

import java.util.EnumMap;
import lotto.domain.Reward;

public class GameResultResponse {
    private EnumMap<Reward, Integer> rewards;
    private String profit;

    public GameResultResponse(EnumMap<Reward, Integer> rewards, String profit) {
        this.rewards = rewards;
        this.profit = profit;
    }

    public EnumMap<Reward, Integer> getRewards() {
        return rewards;
    }

    public String getProfit() {
        return profit;
    }
}
