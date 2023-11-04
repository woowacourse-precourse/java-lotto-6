package lotto;

import lotto.controller.InputController;
import lotto.controller.LottoGameController;
import lotto.controller.OutputController;

public class Application {
    public static void main(String[] args) {
        InputController inputController = new InputController();
        OutputController outputController = new OutputController();
        LottoGameController lottoGameController = new LottoGameController(inputController, outputController);
        lottoGameController.run();
    }
}