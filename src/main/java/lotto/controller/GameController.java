package lotto.controller;

import lotto.service.GameService;

public class GameController {

    private final GameService gameService = new GameService();

    public void purchaseLotto(String input){

        gameService.purchaseLotto(input);
    }


}
