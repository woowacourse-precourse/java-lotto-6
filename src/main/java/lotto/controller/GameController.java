package lotto.controller;

import lotto.service.GameService;

public class GameController {

    private GameService gameService = new GameService();

    public void gameStart() {
        gameService.play();
    }
}
