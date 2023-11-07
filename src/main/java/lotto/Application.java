package lotto;

import lotto.game.GameManager;

public class Application {
    public static void main(String[] args) {
        LottoGame game = new LottoGame();
        GameManager gameManager = new GameManager(game);
        gameManager.start();
    }
}
