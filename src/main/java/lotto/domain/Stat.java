package lotto.domain;

import java.util.HashMap;
import java.util.Map;

import lotto.config.Config;
import lotto.view.AdminInputOutputMessage;

public class Stat {

    public enum Reward {
        THREE(3, 5_000, AdminInputOutputMessage.FIFTH_GRADE),
        FOUR(4, 50_000, AdminInputOutputMessage.FOURTH_GRADE),
        FIVE(5, 1_500_000, AdminInputOutputMessage.THIRD_GRADE),
        BONUS(5, 30_000_000, AdminInputOutputMessage.SECOND_GRADE),
        SIX(6, 2_000_000_000, AdminInputOutputMessage.FIRST_GRADE);

        private final int correctNumberCount;
        private final int reward;
        private final String message;

        Reward(int correctNumberCount, int reward, String message) {
            this.reward = reward;
            this.correctNumberCount = correctNumberCount;
            this.message = message;
        }

        public int getReward() {
            return reward;
        }

        public int getCorrectNumberCount() {
            return correctNumberCount;
        }

        public int getCorrectCount() {
            return correctNumberCount;
        }

        public String getMessage() {
            return message;
        }
    }

    private final Map<String, Integer> lottoCorrectStat = new HashMap<>();
    private int reward = 0;

    public Stat() {
        for (Reward count : Reward.values()) {
            lottoCorrectStat.put(count.name(), Config.INIT_VALUE_ZERO);
        }
    }

    public void setReward(int addRewardAmount) {
        reward += addRewardAmount;
    }

    public int getReward() {
        return reward;
    }

    public Map<String, Integer> getLottoCorrectStat() {
        return lottoCorrectStat;
    }
}
