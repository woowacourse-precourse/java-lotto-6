package lotto;

import lotto.controller.GameController;
import lotto.service.GameService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Application {
    public static void main(String[] args) {
        GameService gameService = new GameService();
        GameController gameController = new GameController(gameService);
        gameController.startGame();
        gameController.playGame();
        gameController.endGame();
    }
}
