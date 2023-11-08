package lotto.controller;

import lotto.dto.PurchaseResult;
import lotto.model.LottoBuyer;
import lotto.model.Winning;
import lotto.model.WinningNumbers;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    public void run() {
        OutputView.printReadCashMessage();
        int cash = InputView.readCash();

        LottoBuyer lottoBuyer = new LottoBuyer(cash);
        PurchaseResult purchaseResult = lottoBuyer.purchase();
        OutputView.printPurchaseResult(purchaseResult);

        OutputView.printReadWinningNumberMessage();
        WinningNumbers winningNumbers = new WinningNumbers(InputView.readWinningNumber());
        OutputView.printReadBonusNumberMessage();
        winningNumbers.addBonusNumber(InputView.readBonusNumber());

        Winning winning = Winning.create(winningNumbers, purchaseResult);
        OutputView.printWinningStatistic(winning.getStatistic());
        OutputView.printYield(winning.getYields());
    }

}
