package lotto.controller;

import lotto.domain.Pay;
import lotto.view.InputView;
import lotto.view.OutputView;

public class GameController {
    Pay pay;
    InputView inputView = new InputView();
    OutputView outputView = new OutputView();

    public void run() {
        initGame();
    }

    public void initGame() {
        outputView.printPaymentRequest();
        pay = new Pay(inputView.enterCost());
    }
}
