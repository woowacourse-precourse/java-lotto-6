package lotto;

import lotto.controller.LottoController;
import lotto.service.LottoService;
import lotto.utils.RandomNumberGenerator;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Application {
    public static void main(String[] args) {
        LottoController lottoController = new LottoController(new LottoService(
                new RandomNumberGenerator()), new InputView(), new OutputView());
        lottoController.run();
    }
}
