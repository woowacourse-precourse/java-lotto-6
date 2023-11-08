package lotto;

import lotto.controller.InputController;
import lotto.controller.LottoController;

public class Application {
    public static void main(String[] args) {
        InputController inputController = new InputController();
        LottoController lottoController = new LottoController(inputController);
        lottoController.start();
    }
}