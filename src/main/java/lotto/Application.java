package lotto;

import lotto.controller.GameController;
import lotto.service.GameService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        GameService gameService = new GameService();
        GameController gameController = new GameController(inputView, outputView, gameService);
        gameController.startGame();
        gameController.playGame();
        gameController.endGame();
    }
}
