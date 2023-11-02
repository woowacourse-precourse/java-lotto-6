package lotto.controller;

import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoGameController {

    InputView inputView;
    OutputView outputView;

    public LottoGameController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void play() {
        outputView.printReadMoneyAmountMessage();
        long moneyAmount = inputView.readMoneyAmount();

    }
}
