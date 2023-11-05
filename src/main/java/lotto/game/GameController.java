package lotto.game;

import lotto.view.InputInfo;
import lotto.view.View;

public class GameController {
    private Game game;
    private View view;

    public GameController() {
        game = new Game();
        view = new View();
    }

    public void start() {
        game.purchaseLotto(getPurchaseAmout());
        view.getOutputView().display("");
        view.getOutputView().display(game.getPurchasedLottosInfo());
    }

    private int getPurchaseAmout() {
        view.getOutputView().displayInputPurcaseAmoutMessage();
        InputInfo userInput = view.getInputView().inputPurchaseAmount();
        while (!userInput.isValidate()) {
            view.getOutputView().displayInputPurcaseAmoutMessage();
            userInput = view.getInputView().inputPurchaseAmount();
        }
        return Integer.valueOf(userInput.getUserInput());
    }
}
