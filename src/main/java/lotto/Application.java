package lotto;

import lotto.controller.GameController;
import lotto.domain.LottoGenerator;
import lotto.util.Validator;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Application {
    public static void main(String[] args) {
        GameController gameController = new GameController(
                new InputView(), new OutputView(),
                new Validator(), new LottoGenerator());
        gameController.play();
    }
}
