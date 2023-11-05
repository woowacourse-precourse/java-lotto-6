package lotto;

import lotto.controller.Game;
import lotto.domain.lotto.LottoManager;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Application {
    public static void main(String[] args) {
        Game game = new Game(new InputView(), new OutputView(), new LottoManager());
        game.start();
    }
}
