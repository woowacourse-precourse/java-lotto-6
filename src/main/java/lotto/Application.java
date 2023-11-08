package lotto;

import lotto.core.domain.LottoGame;

public class Application {
    public static void main(String[] args) {
        LottoGame lottoGame = new LottoGame();

        lottoGame.play();
    }
}
