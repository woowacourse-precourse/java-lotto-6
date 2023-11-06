package lotto.controller;

import lotto.service.GameService;

public class GameController {
    GameService gameService;

    public GameController(){
        gameService = new GameService();
    }

}
