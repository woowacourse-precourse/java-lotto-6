package lotto;

import lotto.view.InputView;
import lotto.view.OutputView;

public class Game {
    InputView inputView;
    OutputView outputView;

    public Game() {
        inputView = new InputView();
        outputView = new OutputView();
    }

    public void run(){
        inputView.purchaseAmountView();
        
    }
}
