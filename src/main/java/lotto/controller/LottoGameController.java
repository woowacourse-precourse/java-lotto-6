package lotto.controller;

import lotto.domain.Lotteries;
import lotto.domain.Payment;
import lotto.domain.WinningLotto;

public class LottoGameController {
    
    private final PaymentController paymentController;
    private final PurchaseController purchaseController;
    private final WinningLottoController winningLottoController;
    
    public LottoGameController() {
        this.paymentController = new PaymentController();
        this.purchaseController = new PurchaseController();
        this.winningLottoController = new WinningLottoController();
    }
    
    public void start() {
        final Payment payment = paymentController.receivePayment();
        final Lotteries lotteries = purchaseController.purchaseLotteries(payment);
        final WinningLotto winningLotto = winningLottoController.receiveWinningLotto();
    }
}
