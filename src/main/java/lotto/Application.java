package lotto;

import lotto.controller.Input;
import lotto.controller.LottoController;
import lotto.start.LottoGame;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Input controller = new LottoController();
        LottoGame lottoGame = new LottoGame(controller);
        lottoGame.run();
    }
}
