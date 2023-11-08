package lotto;

import lotto.controller.LottoController;
import lotto.model.service.LottoService;
import lotto.model.service.LottoServiceImpl;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Application {
    public static void main(String[] args) {

        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        LottoService lottoService = new LottoServiceImpl();
        LottoController controller = new LottoController(lottoService, inputView, outputView);

        controller.lottoRun();

    }
}
