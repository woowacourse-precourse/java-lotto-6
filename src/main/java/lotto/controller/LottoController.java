package lotto.controller;

import lotto.model.LottoBuyer;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;


public class LottoController {

    public void run() {
        OutputView.printReadCashMessage();
        int cash = InputView.readCash();
        LottoBuyer lottoBuyer = new LottoBuyer(cash);
        OutputView.printPurchaseResult(lottoBuyer.purchase());
        OutputView.printReadWinningNumberMessage();
        List<Integer> winningNumbers = InputView.readWinningNumber();
    }

}
