package lotto;

import lotto.game.LottoGame;

public class Application {
    public static void main(String[] args) {
        LottoGame.getInstance().start();
    }
}
