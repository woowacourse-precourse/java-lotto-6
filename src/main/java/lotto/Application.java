package lotto;

import lotto.controller.LottoGame;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        LottoGame lottoGame = new LottoGame(new InputView(), new OutputView());
        lottoGame.gameStart();
    }
}
