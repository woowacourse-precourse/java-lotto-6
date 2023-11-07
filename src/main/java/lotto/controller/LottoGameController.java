package lotto.controller;

import lotto.domain.Lotteries;
import lotto.domain.Payment;
import lotto.domain.WinningLotto;
import lotto.service.PaymentService;
import lotto.service.PurchaseService;
import lotto.service.StatisticsService;
import lotto.service.WinningLottoService;

public class LottoGameController {

    private final PaymentService paymentService;
    private final PurchaseService purchaseService;
    private final WinningLottoService winningLottoService;
    private final StatisticsService statisticsService;

    public LottoGameController() {
        this.paymentService = new PaymentService();
        this.purchaseService = new PurchaseService();
        this.winningLottoService = new WinningLottoService();
        this.statisticsService = new StatisticsService();
    }

    public void start() {
        final Payment payment = paymentService.receivePayment();
        final Lotteries lotteries = purchaseService.purchaseLotteries(payment);
        final WinningLotto winningLotto = winningLottoService.receiveWinningLotto();

        statisticsService.receiveGameResult(payment, lotteries, winningLotto);
    }
}
