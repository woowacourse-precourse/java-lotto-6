package lotto;

import lotto.controller.LottoController;
import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.ResultView;

public class Application {
    public static void main(String[] args) {
        LottoService lottoService = new LottoService();
        InputView inputView = new InputView();
        ResultView resultView = new ResultView();
        LottoController lottoController = new LottoController(lottoService, inputView, resultView);

        lottoController.run();
    }
}
