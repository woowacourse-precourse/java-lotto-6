package lotto;

import lotto.controller.LottoController;
import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Application {
    public static void main(String[] args) {
        final LottoService lottoService = new LottoService();
        final InputView inputView = new InputView();
        final OutputView outputView = new OutputView();

        final LottoController lottoController = new LottoController(lottoService, inputView, outputView);
        lottoController.playLotto();
    }
}
