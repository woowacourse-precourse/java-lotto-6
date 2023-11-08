package lotto;

import lotto.game.LottoGame;

public class Application {
    public static void main(String[] args) {
        LottoGame lottoGame = new LottoGame();

        lottoGame.initCost();
        lottoGame.purchaseLottos();

        lottoGame.initTarget();
        lottoGame.initBonusNumber();

        lottoGame.result();

        lottoGame.close();
    }
}
