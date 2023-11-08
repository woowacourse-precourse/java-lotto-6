package lotto.controller;

import lotto.model.LottoBuyer;
import lotto.view.InputView;
import lotto.view.OutputView;


public class LottoController {

    public void run() {
        OutputView.printReadCashMessage();
        int cash = InputView.readCash();
        LottoBuyer lottoBuyer = new LottoBuyer(cash);
        OutputView.printPurchaseResult(lottoBuyer.purchase());
    }

}
