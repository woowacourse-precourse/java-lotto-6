package lotto.controller;

import lotto.model.LottoBuyer;
import lotto.model.WinningNumbers;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    public void run() {
        OutputView.printReadCashMessage();
        int cash = InputView.readCash();
        LottoBuyer lottoBuyer = new LottoBuyer(cash);
        OutputView.printPurchaseResult(lottoBuyer.purchase());
        OutputView.printReadWinningNumberMessage();
        WinningNumbers winningNumbers = new WinningNumbers(InputView.readWinningNumber());
        OutputView.printReadBonusNumberMessage();
        winningNumbers.addBonusNumber(InputView.readBonusNumber());
    }

}
