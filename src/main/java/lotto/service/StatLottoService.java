package lotto.service;

import java.util.List;
import java.util.Map;

import lotto.domain.Stat;
import lotto.domain.Stat.CorrectCount;

public class StatLottoService {
    private Stat stat;
    public Stat setStat(){
        this.stat = new Stat();
        return stat;
    }

    public void findCorrectName(List<Integer> correctLottoNumbers, List<Integer> userNumbers, int bonusNumber, Stat stat) {
        int correctLottoCount = correctLottoNumbers.size();
        if (correctLottoCount == 5) {
            if (userNumbers.contains(bonusNumber)) {
                addBonusStat();
                return;
            }
        }
        for (CorrectCount count : CorrectCount.values()) {
            if (count.getCorrectCount() == correctLottoCount) {
                addRewardToTotalReward(count, stat);
                addCorrectStat(stat.getLottoCorrectStat(), count);
                break;
            }
        }
    }

    public void addRewardToTotalReward(CorrectCount count, Stat stat) {
        if (count != null) {
            Stat.Reward rewardName = stat.getRewardMapping().get(count);
            if (rewardName != null) {
                stat.setReward(rewardName.getReward());
            }
        }
    }

    public void addCorrectStat(Map<String, Integer> lottoCorrectStat, CorrectCount matchingCount) {
        String matchCountName = matchingCount.toString();
        if (lottoCorrectStat.containsKey(matchCountName)) {
            int count = lottoCorrectStat.get(matchCountName);
            lottoCorrectStat.put(matchCountName, count + 1);
        }
    }

    public void addBonusStat() {
        String matchCountName = CorrectCount.BONUS.toString();
        Stat.Reward bonusReward = Stat.Reward.BONUS;
        stat.getLottoCorrectStat().put(matchCountName, 1);
        stat.setReward(bonusReward.getReward());
    }

    public double calculateProfit(int purchaseAmount) {
        return ((double) stat.getReward() / (double) purchaseAmount) * 100;
    }

}
