package lotto.controller;

import lotto.service.GameService;

public class GameMainController {

    private final GameService gameService;

    public GameMainController(GameService gameService) {
        this.gameService = gameService;
    }

    public void run() {
    }
}
