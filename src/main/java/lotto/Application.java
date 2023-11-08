package lotto;

import lotto.controller.Game;
import lotto.controller.LottoGame;

public class Application {
    public static void main(String[] args) {
        Game lottoGame = new LottoGame();
        lottoGame.run();
    }
}
