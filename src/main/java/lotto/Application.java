package lotto;

import lotto.controller.LottoController;
import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.OutputView;
import lotto.view.View;

public class Application {
    public static void main(String[] args) {
        View view = new View(new InputView(), new OutputView());
        LottoController lottoController = new LottoController(new LottoService(), view);
        lottoController.run();
    }
}
