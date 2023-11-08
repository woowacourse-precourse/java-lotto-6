package lotto.lottoResults.service;

import java.util.List;
import lotto.lotto.domain.Lotteries;
import lotto.lottoResults.domain.LottoStatistics;

public class LottoStatisticsService {

    private final LottoStatistics lottoStatistics;

    private final LottoResultsService lottoResultsService;

    public LottoStatisticsService(LottoStatistics lottoStatistics, LottoResultsService lottoResultsService) {
        this.lottoStatistics = lottoStatistics;
        this.lottoResultsService = lottoResultsService;
    }

    public void printTotalStatistics(Lotteries lotteries, Integer spendMoney) {
        List<Integer> winningNumbersWithBonus = lottoResultsService.insultWinningNumbersWithBonusNumber();
        List<Integer> ranks = lotteries.calculateAllLottoRanks(winningNumbersWithBonus);
        calculateTotalStatistics(ranks);
        lottoStatistics.printStatistics();
        lottoStatistics.printReturnRate(spendMoney);
    }

    private void calculateTotalStatistics(List<Integer> ranks) {
        for (Integer rank : ranks) {
            lottoStatistics.incrementCount(rank);
        }
    }

}
