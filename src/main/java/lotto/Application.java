package lotto;

import controller.LottoGame;
import view.InputView;
import view.OutputView;
import view.View;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        View view = new View(new InputView(), new OutputView());
        LottoGame lottoGame = new LottoGame(view);
        lottoGame.execute();
    }
}
