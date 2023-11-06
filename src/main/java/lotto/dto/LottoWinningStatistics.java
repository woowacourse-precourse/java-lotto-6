package lotto.dto;

import java.util.Map;
import lotto.domain.LottoPrize;

public class LottoWinningStatistics {

    private final double rewardRatio;
    private final Map<LottoPrize, Integer> prizeCountMap;

    public LottoWinningStatistics(double rewardRatio, Map<LottoPrize, Integer> prizeCountMap) {
        this.rewardRatio = rewardRatio;
        this.prizeCountMap = prizeCountMap;
    }

    public double getRewardRatio() {
        return rewardRatio;
    }

    public int getCountLottoPrize(LottoPrize lottoPrize) {
        return prizeCountMap.getOrDefault(lottoPrize, 0);
    }
}
