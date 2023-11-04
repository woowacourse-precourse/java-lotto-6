package lotto.service;

import lotto.domain.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoResultService {
    public List<LottoResult> countMatchingNumbers(PurchasedLotto purchasedLotto, WinningLotto winningLotto) {
        List<LottoResult> lottoResults = new ArrayList<>();

        for (Lotto lotto : purchasedLotto.getLottos()) {
            Integer correctNumbers = winningLotto.countNumbers(lotto);
            Boolean isCorrectBonusNumber = winningLotto.isCorrectBonusNumber(lotto);

            lottoResults.add(new LottoResult(correctNumbers, isCorrectBonusNumber));
        }

        return lottoResults;
    }

    public Map<LottoReward, Integer> confirmRewardLottos(List<LottoResult> lottoResults) {
        Map<LottoReward, Integer> rewardCount = new HashMap<>();

        for (LottoResult lottoResult : lottoResults) {
            LottoReward lottoReward = LottoReward.getReward(lottoResult.getCorrectNumbers(), lottoResult.getCorrectBonusNumber());
            rewardCount.put(lottoReward, rewardCount.getOrDefault(lottoReward, 0) +1);
        }

        return rewardCount;
    }

    public Double countEarnRate(Map<LottoReward, Integer> reward, Integer userMoney) {
        Integer totalProfit = 0;

        for (Map.Entry<LottoReward, Integer> entry : reward.entrySet()) {
            totalProfit += entry.getKey().getReward() * entry.getValue();
        }

        Double earnRate = (double) (totalProfit / userMoney);
        return Math.round(earnRate * 100) / 1.0;
    }
}
