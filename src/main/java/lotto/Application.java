package lotto;

import lotto.lotto.domain.Lotteries;
import lotto.purchase.service.PurchaseService;
import lotto.results.domain.Results;
import lotto.results.domain.Statistics;
import lotto.results.service.ResultsService;
import lotto.results.service.StatisticsService;

public class Application {
    public static void main(String[] args) {
        PurchaseService purchaseService = new PurchaseService();
        Results results = new Results();
        ResultsService resultsService = new ResultsService(results);
        Statistics statistics = new Statistics();
        StatisticsService statisticsService = new StatisticsService(statistics,
                resultsService);

        Lotteries lotteries = purchaseService.process();
        Integer spendMoney = purchaseService.getSpendMoney();
        lotteries.printAllLotteries();
        statisticsService.printTotalStatistics(lotteries, spendMoney);
    }
}
