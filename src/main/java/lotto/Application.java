package lotto;

import lotto.ui.InputView;
import lotto.ui.OutputView;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        GameController gameController = new GameController(inputView, outputView);

        gameController.play();
    }
}
