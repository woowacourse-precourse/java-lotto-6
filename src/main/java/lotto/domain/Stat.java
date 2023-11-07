package lotto.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import lotto.config.Config;

enum CorrectCount {
    NOT(0), ONE(1), TWO(2), THREE(3), FOUR(4), FIVE(5), BONUS(7), SIX(6);

    private int correctCount;

    private CorrectCount(int correctCount) {
        this.correctCount = correctCount;
    }

    public int getCorrectCount() {
        return correctCount;
    }
}

enum Reward {
    THREE(5000), FOUR(50000), FIVE(1500000), BONUS(30000000), SIX(2000000000);

    private int reward;

    private Reward(int reward) {
        this.reward = reward;
    }

    public int getReward() {
        return reward;
    }
}

public class Stat {
    private Map<String, Integer> lottoCorrectStat = new HashMap<>();
    private CorrectCount matchingCount = null;
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

    public CorrectCount getMatchingCount() {
        return matchingCount;
    }

    public Map<String, Integer> getlottoCorrectStat() {
        return lottoCorrectStat;
    }

    public void findCorrectName(List<Integer> correctLottoNumbers, List<Integer> userNumbers, int bonusNumber) {
        int correctLottoCount = correctLottoNumbers.size();
        if (correctLottoCount == 5) {
            if(userNumbers.contains(bonusNumber)){
                addBonusStat(userNumbers, bonusNumber);
                return;
            }
        }
        for (CorrectCount count : CorrectCount.values()) {
            if (count.getCorrectCount() == correctLottoCount) {
                matchingCount = count;
                addRewardToTotalReward(count);
                addCorrectStat();
                break;
            }
        }
    }

    private void addRewardToTotalReward(CorrectCount count) {
        if (count != null) {
            Reward rewardName = rewardMapping.get(count);
            if (rewardName != null) {
                reward += rewardName.getReward();
            }
        }
    }

    public void addCorrectStat() {
        String matchCountName = matchingCount.toString();
        if (lottoCorrectStat.containsKey(matchCountName)) {
            int count = lottoCorrectStat.get(matchCountName);
            lottoCorrectStat.put(matchCountName, count + 1);
            return;
        }
    }

    public void addBonusStat(List<Integer> userNumbers, int bonusNumber) {
        String matchCountName = CorrectCount.BONUS.toString();
        Reward bonusReward = Reward.BONUS;
        lottoCorrectStat.put(matchCountName, 1);
        reward += bonusReward.getReward();
    }

    public double calculateProfit(int purchaseAmount){
        double profit = ((double)reward/(double)purchaseAmount)*100;
        return profit;
    }
}
