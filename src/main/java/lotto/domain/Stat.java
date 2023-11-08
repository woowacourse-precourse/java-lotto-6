package lotto.domain;

import java.util.HashMap;
import java.util.Map;

import lotto.config.Config;

public class Stat {

    public enum Reward {
        THREE(5000), FOUR(50000), FIVE(1500000), BONUS(30000000), SIX(2000000000);

        private final int reward;

        Reward(int reward) {
            this.reward = reward;
        }

        public int getReward() {
            return reward;
        }
    }

    public enum CorrectCount {
        NOT(0), ONE(1), TWO(2), THREE(3), FOUR(4), FIVE(5), BONUS(7), SIX(6);

        private final int correctCount;

        CorrectCount(int correctCount) {
            this.correctCount = correctCount;
        }

        public int getCorrectCount() {
            return correctCount;
        }
    }

    private final Map<String, Integer> lottoCorrectStat = new HashMap<>();
    private static final Map<CorrectCount, Reward> rewardMapping = new HashMap<>();
    private int reward = 0;

    static {
        rewardMapping.put(CorrectCount.THREE, Reward.THREE);
        rewardMapping.put(CorrectCount.FOUR, Reward.FOUR);
        rewardMapping.put(CorrectCount.FIVE, Reward.FIVE);
        rewardMapping.put(CorrectCount.SIX, Reward.SIX);
    }

    public Stat() {
        for (CorrectCount count : CorrectCount.values()) {
            lottoCorrectStat.put(count.name(), Config.CORRECT_COUNT_INIT_VALUE);
        }
    }

    public void setReward(int addRewardAmount){
        reward+=addRewardAmount;
    }

    public int getReward() {
        return reward;
    }

    public Map<String, Integer> getLottoCorrectStat() {
        return lottoCorrectStat;
    }

    public Map<CorrectCount, Reward> getRewardMapping() {
        return rewardMapping;
    }

    
}
