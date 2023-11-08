package lotto.controller;

import lotto.model.BonusNumber;
import lotto.model.PurchaseAmount;
import lotto.model.WinningNumber;
import lotto.util.ConvertUtil;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private static final InputView inputView = new InputView();
    private static final OutputView outputView = new OutputView();

    public void start() {

    }

    private PurchaseAmount getPurchaseAmount() {
        outputView.printPurchaseAmountInputMessage();
        return new PurchaseAmount(inputView.readPurchaseAmount());
    }

    private WinningNumber getWinningNumber() {
        outputView.printWinningNumbersInputMessage();
        return new WinningNumber(inputView.readWinningNumber());
    }

    private BonusNumber getBonusNumber() {
        outputView.printBonusNumberInputMessage();
        return new BonusNumber(inputView.readBonusNumber());
    }
}
