package lotto;

import lotto.lotto.domain.Lotteries;
import lotto.lottoPurchase.service.LottoPurchaseService;
import lotto.lottoResults.domain.LottoResults;
import lotto.lottoResults.domain.LottoStatistics;
import lotto.lottoResults.service.LottoResultsService;
import lotto.lottoResults.service.LottoStatisticsService;

public class Application {
    public static void main(String[] args) {
        LottoPurchaseService lottoPurchaseService = new LottoPurchaseService();
        LottoResults lottoResults = new LottoResults();
        LottoResultsService lottoResultsService = new LottoResultsService(lottoResults);
        LottoStatistics lottoStatistics = new LottoStatistics();
        LottoStatisticsService lottoStatisticsService = new LottoStatisticsService(lottoStatistics,
                lottoResultsService);

        Lotteries lotteries = lottoPurchaseService.process();
        Integer spendMoney = lottoPurchaseService.getSpendMoney();
        lotteries.printAllLotteries();
        lottoStatisticsService.printTotalStatistics(lotteries, spendMoney);
    }
}
