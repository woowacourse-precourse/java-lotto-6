package lotto.service;

import lotto.domain.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoResultService {

    private static final int INITIAL_COUNT = 0;
    private static final int INCREMENT = 1;
    private static final double PERCENTAGE = 100.0;

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
            rewardCount.put(lottoReward, rewardCount.getOrDefault(lottoReward, INITIAL_COUNT) + INCREMENT);
        }

        return rewardCount;
    }

    public Double countEarnRate(Map<LottoReward, Integer> reward, Integer userMoney) {
        Integer totalProfit = INITIAL_COUNT;

        for (Map.Entry<LottoReward, Integer> entry : reward.entrySet()) {
            totalProfit += entry.getKey().getReward() * entry.getValue();
        }

        Double earnRate = (double) totalProfit / userMoney * PERCENTAGE;
        return Math.round(earnRate * PERCENTAGE) / PERCENTAGE;
    }
}
