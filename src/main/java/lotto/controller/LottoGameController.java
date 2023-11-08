package lotto.controller;

import lotto.model.*;

import java.util.List;

public class LottoGameController {
    private final PaymentController paymentController = new PaymentController();
    private final LottoPurchaseController lottoPurchaseController = new LottoPurchaseController();
    private final WinningsInitController winningsInitController = new WinningsInitController();
    private final StatisticsController statisticsController = new StatisticsController();
    private final RankCalculator rankCalculator = new RankCalculator();

    public void run() {
        int userPayment = paymentController.getUserPayment();
        List<Lotto> purchasedLotto = lottoPurchaseController.purchase(userPayment);
        Lotto winningLotto = winningsInitController.initWinningLotto();
        int bonusNumber = winningsInitController.initBonusNumber(winningLotto);
        List<Rank> ranks = rankCalculator.calculateAllRanks(purchasedLotto, winningLotto, bonusNumber);
        RankStatistics rankStatistics = new RankStatistics(ranks);
        statisticsController.printStatistics(rankStatistics);
        statisticsController.printProfitRate(rankStatistics, userPayment);
    }
}