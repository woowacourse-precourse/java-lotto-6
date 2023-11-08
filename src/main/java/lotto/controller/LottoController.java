package lotto.controller;

import lotto.domain.*;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

public class LottoController {
    private Purchasing purchasing = new Purchasing();
    private WinningLotto winningLotto = new WinningLotto();
    private Payment payment = new Payment();

    public void startLottoGame() {
        payForLotto();
        purchase();
        getPurchasingResult();
        storeWinningLotto();
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

    private void storeWinningLotto() {
        OutputView.askWinningLottoNumbers();
        List<Integer> winningLottoNumbers = InputView.getWinningLottoNumbers();
        winningLotto.storeWinningLottos(winningLottoNumbers);

        OutputView.askBonusNumber();
        int bonusNumber = InputView.getBonusNumber();
        winningLotto.storeBonusNumber(bonusNumber);
    }

    private void getWinningResult() {
        Lotto lotto = winningLotto.getWinningLotto();
        int bonusNumber = winningLotto.getBonusNumber();
        List<Lotto> purchasedLottos = purchasing.getPurchasedLottos();

        Result result = new Result(lotto, bonusNumber, purchasedLottos);
        List<Integer> matches = result.getMatchCount();
        Double profitMargin = result.getProfitMargin();

        OutputView.printResultTitle();
        OutputView.printMathCount(matches);
        OutputView.printProfitMargin(profitMargin);
    }
}
