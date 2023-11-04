package lotto;

import lotto.controller.LottoGameController;
import lotto.view.InputView;
import lotto.view.OutputView;
import lotto.view.View;

public class Application {
    public static void main(String[] args) {
        LottoGameController lottoGameController = new LottoGameController(
                new View(new InputView(), new OutputView()));
        lottoGameController.run();
    }
}
