package lotto;

import lotto.controller.LottoController;
import lotto.view.InputView;
import lotto.view.OuputView;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        OuputView ouputView = new OuputView();
        LottoController lottoController = new LottoController(inputView, ouputView);
        lottoController.run();
    }
}
