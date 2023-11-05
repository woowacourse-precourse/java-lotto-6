package lotto.controller;

import lotto.service.GameService;
import lotto.view.GameOutput;

public class GameController {
    private static GameService gameService = new GameService();

    public void run() {
        gameService.start();
        GameOutput.printBlankLine();
        gameService.gameSetting();
        GameOutput.printBlankLine();
        gameService.gameInProgress();
        GameOutput.printBlankLine();
        gameService.result();

    }
}
