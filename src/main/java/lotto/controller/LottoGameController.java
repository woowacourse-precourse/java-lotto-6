package lotto.controller;

import lotto.domain.Lotteries;
import lotto.domain.Payment;
import lotto.domain.WinningLotto;

public class LottoGameController {

    private final PaymentController paymentController;
    private final PurchaseController purchaseController;
    private final WinningLottoController winningLottoController;
    private final StatisticsController statisticsController;

    public LottoGameController() {
        this.paymentController = new PaymentController();
        this.purchaseController = new PurchaseController();
        this.winningLottoController = new WinningLottoController();
        this.statisticsController = new StatisticsController();
    }

    public void start() {
        final Payment payment = paymentController.receivePayment();
        final Lotteries lotteries = purchaseController.purchaseLotteries(payment);
        final WinningLotto winningLotto = winningLottoController.receiveWinningLotto();

        statisticsController.receiveGameResult(lotteries, winningLotto);
    }
}
