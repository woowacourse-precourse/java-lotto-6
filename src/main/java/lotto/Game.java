package lotto;

import lotto.view.InputView;
import lotto.view.OutputView;

public class Game {
    private InputView inputView;
    private OutputView outputView;

    public Game() {
        inputView = new InputView();
        outputView = new OutputView();
    }

    public void run(){
        inputView.purchaseAmountView();

    }
}
