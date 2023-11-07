package lotto;

import Controller.LottoController;
import View.InputView;
import View.OutputView;

public class Application {
    public static void main(String[] args) {
        LottoController lottoController = new LottoController(new InputView(), new OutputView());
        lottoController.run();
    }
}
