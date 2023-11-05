package lotto;

import lotto.controller.LottoController;
import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.ResultView;

public class Application {

    public static void main(String[] args) {

        LottoController lottoController = new LottoController(new LottoService(), new InputView(), new ResultView());
        lottoController.startLotto();
    }
}
