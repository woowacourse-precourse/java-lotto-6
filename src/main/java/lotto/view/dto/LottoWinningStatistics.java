package lotto.view.dto;

import java.util.Map;
import lotto.domain.LottoPrize;
import lotto.domain.LottoWinningResult;

public class LottoWinningStatistics {

    private final double rewardRatio;
    private final Map<LottoPrize, Integer> prizeCounts;

    private LottoWinningStatistics(double rewardRatio, Map<LottoPrize, Integer> prizeCounts) {
        this.rewardRatio = rewardRatio;
        this.prizeCounts = prizeCounts;
    }

    public double getRewardRatio() {
        return rewardRatio;
    }

    public int getCountLottoPrize(LottoPrize lottoPrize) {
        return prizeCounts.getOrDefault(lottoPrize, 0);
    }

    public static LottoWinningStatistics from(LottoWinningResult lottoWinningResult) {
        return new LottoWinningStatistics(
                lottoWinningResult.calculateRewardRatio(),
                lottoWinningResult.getprizeCounts());
    }
}
