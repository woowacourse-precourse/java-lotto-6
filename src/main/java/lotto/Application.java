package lotto;

import lotto.controller.LottoGame;
import lotto.view.OutputView;

public class Application {
    public static void main(String[] args) {
        LottoGame lottoGame = new LottoGame();
        lottoGame.run();
    }
}
