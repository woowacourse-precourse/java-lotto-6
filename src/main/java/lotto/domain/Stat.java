package lotto.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

enum CorrectCount {
    THREE(3), FOUR(4), FIVE_NOT_BONUS(5), SIX(6);

    private int correctCount;

    private CorrectCount(int correctCount) {
        this.correctCount = correctCount;
    }

    public int getCorrectCount() {
        return correctCount;
    }
}

enum Reward {
    THREE(5000), FOUR(50000), FIVE(1500000), SIX(2000000000);

    private int reward;

    private Reward(int reward) {
        this.reward = reward;
    }

    public int getCorrectCount() {
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
        rewardMapping.put(CorrectCount.FIVE_NOT_BONUS, Reward.FIVE);
        rewardMapping.put(CorrectCount.SIX, Reward.SIX);
    }
    public Stat() {
        for (CorrectCount count : CorrectCount.values()) {
            lottoCorrectStat.put(count.name(), 0);
        }
        lottoCorrectStat.put("BONUS", 0);
    }
    public int getReward() {
        return reward;
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
            addBonusStat(userNumbers, bonusNumber);
        }
        for (CorrectCount count : CorrectCount.values()) {
            if (count.getCorrectCount() == correctLottoCount) {
                matchingCount = count;
                addRewardToTotalReward(count);
                break;
            }
        }
    }

    private void addRewardToTotalReward(CorrectCount count) {
        if (count != null) {
            Reward rewardName = rewardMapping.get(count);
            if (rewardName != null) {
                reward += rewardName.getCorrectCount();
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
        if (!userNumbers.contains(bonusNumber)) {
            return;
        }
        String matchCountName = "BONUS";
        lottoCorrectStat.put(matchCountName, 1);
        reward += 30000000;
        // System.out.println(reward);
    }
}
