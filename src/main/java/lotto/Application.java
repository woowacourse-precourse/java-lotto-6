package lotto;

import lotto.controller.RunLottoGame;

public class Application {
    public static void main(String[] args) {
        RunLottoGame game = new RunLottoGame();
        game.gameIntro();
        game.Matching();
        game.terminateGame();
    }
}
