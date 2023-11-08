package lotto.controller;

import lotto.domain.Lotteries;
import lotto.domain.Payment;
import lotto.domain.RankingResult;
import lotto.domain.WinningLotto;
import lotto.service.PaymentService;
import lotto.service.ProfitabilityService;
import lotto.service.PurchaseService;
import lotto.service.StatisticsService;
import lotto.service.WinningLottoService;

public class LottoGameController {

    private final PaymentService paymentService;
    private final PurchaseService purchaseService;
    private final WinningLottoService winningLottoService;
    private final StatisticsService statisticsService;

    private final ProfitabilityService profitabilityService;

    public LottoGameController() {
        this.paymentService = new PaymentService();
        this.purchaseService = new PurchaseService();
        this.winningLottoService = new WinningLottoService();
        this.statisticsService = new StatisticsService();
        this.profitabilityService = new ProfitabilityService();
    }

    public void start() {
        final Payment payment = paymentService.receivePayment();
        final Lotteries lotteries = purchaseService.purchaseLotteries(payment);
        final WinningLotto winningLotto = winningLottoService.receiveWinningLotto();

        RankingResult rankingResult = statisticsService.receiveGameResult(lotteries, winningLotto);

        profitabilityService.calculateProfitability(payment, rankingResult);
    }
}
