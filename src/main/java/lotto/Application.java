package lotto;

import lotto.controller.LottoController;
import lotto.view.InputView;
import lotto.view.OutPutView;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutPutView outputView = new OutPutView();

        LottoController lottoController = new LottoController(inputView, outputView);
        lottoController.start();
    }
}
