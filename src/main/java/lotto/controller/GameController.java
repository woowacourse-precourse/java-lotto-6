package lotto.controller;

import lotto.service.GameService;

public class GameController {
    GameService gameService;

    public GameController(){
        gameService = new GameService();
    }

    public void Lotto(){
        gameService.purchase();
        gameService.generateLottoNumber();
        gameService.winningNumber();
        gameService.bonusNumber();
        gameService.winning();
        gameService.revenue();
    }

}
