package lotto;

import lotto.controller.LottoController;
import lotto.service.LottoService;
import lotto.validation.InputValidator;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Application {

    static LottoController lottoController = new LottoController(new LottoService(), new InputView(new InputValidator()), new OutputView());

    public static void main(String[] args) {
        lottoController.run();
    }
}
