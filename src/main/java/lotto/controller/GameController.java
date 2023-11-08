package lotto.controller;

import lotto.service.play.GamePlay;
import lotto.service.play.LottoGamePlay;

public class GameController {
    private final GamePlay gamePlay;

    public GameController() {
        this.gamePlay = new LottoGamePlay();
    }
    public void run(){
        gamePlay.play();
    }
}
