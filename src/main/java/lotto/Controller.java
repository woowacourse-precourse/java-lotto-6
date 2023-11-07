package lotto;

import lotto.Service.GameService;

public class Controller {

    GameService gameService = new GameService();

    public void run() throws IllegalArgumentException {
        setGame();
        resultGame();
    }

    private void setGame() {
        gameService.setGame();;
    }

    private void resultGame() {
        gameService.resultGame();
    }
}
