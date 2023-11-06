package lotto;

import lotto.service.LottoGame;

public class Application {
    public static void main(String[] args) {
        LottoGame lottoGame = new LottoGame();
        lottoGame.game();
    }
}
