package lotto.controller;

import lotto.model.BoughtLotto;
import lotto.model.Result;
import lotto.model.WinningNumbers;

public class Controller {

    private BoughtLotto boughtLotto;
    private WinningNumbers winningNumbers;
    private final Result result = new Result();
    private final BuyController buyController = new BuyController();
    private final InputWinningNumberController inputWinningNumberController = new InputWinningNumberController();
    private CheckResultController checkResultController;
    private final ReturnResultController returnResultController = new ReturnResultController(result);

    public void run() {
        buyLotto();
        inputWinningNumber();
        checkLottoResult();
        returnResult();
    }

    private void buyLotto() {
        boughtLotto = new BoughtLotto(buyController.savePrice());
        buyController.printBoughtLotto(boughtLotto);
    }

    private void inputWinningNumber() {
        winningNumbers = new WinningNumbers(inputWinningNumberController.saveWinLottoNumber(),
                inputWinningNumberController.saveBonusNumber());
    }

    private void checkLottoResult() {
        checkResultController = new CheckResultController(boughtLotto, winningNumbers, result);
        checkResultController.checkMatchResult();
        checkResultController.checkEarningRate();
    }

    private void returnResult() {
        returnResultController.printStatistics();
    }
}
