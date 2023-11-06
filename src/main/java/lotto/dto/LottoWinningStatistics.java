package lotto.dto;

import java.util.Map;
import lotto.domain.LottoPrize;
import lotto.domain.LottoWinningResult;

public class LottoWinningStatistics {

    private final double rewardRatio;
    private final Map<LottoPrize, Integer> prizeCountMap;

    private LottoWinningStatistics(double rewardRatio, Map<LottoPrize, Integer> prizeCountMap) {
        this.rewardRatio = rewardRatio;
        this.prizeCountMap = prizeCountMap;
    }

    public double getRewardRatio() {
        return rewardRatio;
    }

    public int getCountLottoPrize(LottoPrize lottoPrize) {
        return prizeCountMap.getOrDefault(lottoPrize, 0);
    }

    public static LottoWinningStatistics from(LottoWinningResult lottoWinningResult) {
        return new LottoWinningStatistics(
                lottoWinningResult.calculateRewardRatio(),
                lottoWinningResult.getTable());
    }
}
