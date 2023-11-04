package lotto.controller;

import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();

    public void playGame() {
        String inputPurchaseMoney = purchaseMoneyProcess();
    }

    private String purchaseMoneyProcess() {
        outputView.printPurchaseMoneyMessage();
        String inputPurchaseMoney = inputView.inputPurchaseMoney();
        printBlankLine();
        return inputPurchaseMoney;
    }

    private void printBlankLine() {
        outputView.printBlankLine();
    }
}
