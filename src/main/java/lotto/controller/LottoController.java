package lotto.controller;

import lotto.domain.Lotto;
import lotto.domain.Purchasing;
import lotto.domain.Payment;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;
public class LottoController {
    private Purchasing purchasing = new Purchasing();
    private Payment payment = new Payment();

    public void startLottoGame() {
        payForLotto();
        purchase();
        getPurchasingResult();
        storeWiningLotto();
        getWinningResult();
    }

    private void payForLotto() {
        OutputView.askPurchasingPrice();
        int price = InputView.getPurchasingPrice();
        payment.storePaymentAmount(price);
    }

    private void purchase() {
        int ticketQuantity = payment.getAvailableLottoTicketQuantity();
        purchasing.purchaseLottos(ticketQuantity);
    }

    private void getPurchasingResult() {
        int purchasedLottoQuantity = purchasing.getPurchasedLottoQuantity();
        List<Lotto> purchasedLottosResult = purchasing.getPurchasedLottos();
        OutputView.printPurchaseLottoQuantity(purchasedLottoQuantity);
        OutputView.printPurchasedLottos(purchasedLottosResult);
    }

    private void storeWiningLotto() {

    }

    private void getWinningResult() {

    }
}
