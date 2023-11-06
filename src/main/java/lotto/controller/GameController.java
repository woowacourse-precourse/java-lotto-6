package lotto.controller;

import lotto.service.GameService;

public class GameController {
    public static void startLottoGame(){
        GameService.startGame();
        GameService.playGame();
    }
}
