package lotto.controller;

import lotto.domain.PurchasedLottos;
import lotto.domain.Payment;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private PurchasedLottos purchasedLottos = new PurchasedLottos();
    private Payment payment = new Payment();

    public void startLottoGame() {
        payForLotto();
        getPurchasingResult();
        storeWiningLotto();
        getWinningResult();
    }

    private void payForLotto() {
        OutputView.askPurchasingPrice();
        int price = InputView.getPurchasingPrice();
        payment.storePaymentAmount(price);
    }

    private void getPurchasingResult() {
    }

    private void storeWiningLotto() {

    }

    private void getWinningResult() {

    }
}
