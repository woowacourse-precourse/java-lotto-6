package lotto.controller;

import lotto.domain.LottoGame;

public class GameController implements LottoGame {

    private GameController() {}

    public static void start() {
        LottoGame.play();
    }
}
