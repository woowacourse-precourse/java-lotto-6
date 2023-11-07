package lotto.service;

import lotto.domain.LottoResult;
import lotto.domain.LottoReward;
import lotto.domain.PurchasedLotto;
import lotto.domain.WinningLotto;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static lotto.constants.OutputConstants.LOTTO_PRICE;
import static lotto.constants.ServiceConstants.*;

public class LottoResultService {
    public List<LottoResult> countMatchingNumbers(PurchasedLotto purchasedLotto, WinningLotto winningLotto) {
        return purchasedLotto.getLottos().stream()
                .map(lotto -> new LottoResult(winningLotto.countCorrectNumbers(lotto), winningLotto.isCorrectBonusNumber(lotto)))
                .collect(Collectors.toList());
    }

    public Map<LottoReward, Integer> confirmRewardLottos(List<LottoResult> lottoResults) {
        return lottoResults.stream()
                .map(lottoResult -> LottoReward.getReward(lottoResult.getCorrectNumbers(), lottoResult.getCorrectBonusNumber()))
                .collect(Collectors.groupingBy(lottoReward -> lottoReward, Collectors.summingInt(e -> INCREMENT)));
    }

    public Double countEarnRate(Map<LottoReward, Integer> reward, Long lottoCount) {
        Integer totalProfit = calculateTotalProfit(reward);
        return calculateProfitRate(totalProfit, lottoCount);
    }

    private Integer calculateTotalProfit(Map<LottoReward, Integer> reward) {
        return INITIAL_COUNT + reward.entrySet().stream()
                .mapToInt(entry -> entry.getKey().getReward() * entry.getValue())
                .sum();
    }

    private Double calculateProfitRate(Integer totalProfit, Long lottoCount) {
        double totalSpent = lottoCount * LOTTO_PRICE;
        double rawProfitRate = totalProfit / totalSpent;
        double profitRatePercentage = rawProfitRate * PERCENTAGE;

        return Math.round(profitRatePercentage * PERCENTAGE) / PERCENTAGE;
    }

}
