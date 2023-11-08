package lotto.service;

import java.util.List;
import java.util.Map;

import lotto.config.Config;
import lotto.domain.Stat;
import lotto.domain.Stat.Reward;

public class StatLottoService {
    private Stat stat;

    public StatLottoService() {
        stat = setStat();
    }

    public Stat setStat() {
        stat = new Stat();
        return stat;
    }

    public void findCorrectName(List<Integer> correctLottoNumbers, List<Integer> userNumbers, int bonusNumber,
            Stat stats) {
        int correctLottoCount = correctLottoNumbers.size();
        if (correctLottoCount == Config.BONUS_CORRECT_COUNT) {
            if (userNumbers.contains(bonusNumber)) {
                addBonusStat(stats);
                return;
            }
        }
        for (Reward count : Reward.values()) {
            if (count.getCorrectNumberCount() == correctLottoCount) {
                addRewardToTotalReward(count, stats);
                addCorrectStat(stats.getLottoCorrectStat(), count);
                break;
            }
        }
    }

    public void addRewardToTotalReward(Reward count, Stat stats) {
        stats.setReward(count.getReward());
    }

    public void addCorrectStat(Map<String, Integer> lottoCorrectStat, Reward matchingCount) {
        if (lottoCorrectStat.containsKey(matchingCount.name())) {
            int correctCount = lottoCorrectStat.get(matchingCount.name());
            lottoCorrectStat.put(matchingCount.name(), correctCount + 1);
        }
    }

    public void addBonusStat(Stat stats) {
        String correctNumberCount = Reward.BONUS.name();
        int bonusReward = Reward.BONUS.getReward();
        int correctCount = stats.getLottoCorrectStat().get(correctNumberCount);
        stats.getLottoCorrectStat().put(correctNumberCount, correctCount + 1);
        stats.setReward(bonusReward);
    }

    public double calculateProfit(int purchaseAmount, Stat stats) {
        return ((double) stats.getReward() / (double) purchaseAmount) * 100;
    }

}
