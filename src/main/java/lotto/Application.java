package lotto;

import lotto.controller.BuyPriceController;
import lotto.controller.LottoController;
import lotto.controller.LottoGame;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        LottoGame lottoGame = new LottoGame();
        lottoGame.game();
    }
}
