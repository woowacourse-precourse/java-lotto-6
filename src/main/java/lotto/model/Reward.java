package lotto.model;

import java.util.HashMap;
import java.util.Map;

public class Reward {
    private static final int FIRST_RANK_REWARD = 2000000000;
    private static final int SECOND_RANK_REWARD = 30000000;
    private static final int THIRD_RANK_REWARD = 1500000;
    private static final int FOURTH_RANK_REWARD = 50000;
    private static final int FIFTH_RANK_REWARD = 5000;
    private final Map<String, Integer> rewardTable;
    private int reward;

    public Reward() {
        this.rewardTable = new HashMap<>();
        this.rewardTable.put("1st", FIRST_RANK_REWARD);
        this.rewardTable.put("2nd", SECOND_RANK_REWARD);
        this.rewardTable.put("3rd", THIRD_RANK_REWARD);
        this.rewardTable.put("4th", FOURTH_RANK_REWARD);
        this.rewardTable.put("5th", FIFTH_RANK_REWARD);
    }

    public int getReward() {
        return reward;
    }

    public void calculate(Map<String, Long> winningResult) {
        winningResult.forEach((rank, purchaseNum) -> {
            reward += rewardTable.get(rank) * purchaseNum;
        });
    }
}
