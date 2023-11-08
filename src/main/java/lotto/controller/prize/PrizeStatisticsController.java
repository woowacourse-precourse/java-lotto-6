package lotto.controller.prize;

import lotto.domain.lotto.LottoGroup;
import lotto.domain.lotto.LottoPurchaseAmount;
import lotto.domain.prize.Prize;
import lotto.domain.prize.ranking.PrizeRankingCount;
import lotto.domain.prize.statistics.EarningRate;
import lotto.domain.prize.statistics.PrizeStatistics;
import lotto.domain.prize.statistics.TotalPrizeAmount;
import lotto.view.output.LottoStatisticsOutputView;

public class PrizeStatisticsController {
    private final LottoStatisticsOutputView lottoStatisticsOutputView;

    public PrizeStatisticsController(final LottoStatisticsOutputView lottoStatisticsOutputView) {
        this.lottoStatisticsOutputView = lottoStatisticsOutputView;
    }

    public void publish(
            final LottoGroup lottoGroup,
            final Prize prize,
            final LottoPurchaseAmount lottoPurchaseAmount
    ) {
        PrizeStatistics prizeStatistics = new PrizeStatistics(lottoGroup, prize);
        PrizeRankingCount prizeRankingCount = prizeStatistics.getCountsByPrizeRanking();
        TotalPrizeAmount totalPrizeAmount = TotalPrizeAmount.from(prizeRankingCount);
        EarningRate earningRate = new EarningRate(lottoPurchaseAmount, totalPrizeAmount);
        lottoStatisticsOutputView.printPrizeStatistics(prizeRankingCount, earningRate);
    }
}
