package lotto.results.service;

import java.util.List;
import lotto.lotto.domain.Lotteries;
import lotto.results.domain.Statistics;

public class StatisticsService {

    private final Statistics statistics;

    private final ResultsService resultsService;

    public StatisticsService(Statistics statistics, ResultsService resultsService) {
        this.statistics = statistics;
        this.resultsService = resultsService;
    }

    public void printTotalStatistics(Lotteries lotteries, Integer spendMoney) {
        List<Integer> winningNumbersWithBonus = resultsService.insultWinningNumbersWithBonusNumber();
        List<Integer> ranks = lotteries.calculateAllLottoRanks(winningNumbersWithBonus);
        calculateTotalStatistics(ranks);
        statistics.printStatistics();
        statistics.printReturnRate(spendMoney);
    }

    private void calculateTotalStatistics(List<Integer> ranks) {
        for (Integer rank : ranks) {
            statistics.incrementCount(rank);
        }
    }

}
