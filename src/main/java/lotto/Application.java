package lotto;

import lotto.View.InputView;
import lotto.domain.LottoGame;

public class Application {
    public static void main(String[] args) {
        LottoGame lottoGame = new LottoGame();
        lottoGame.run();
    }
}
