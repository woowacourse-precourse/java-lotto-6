package lotto;

import lotto.controller.LottoController;
import lotto.model.LottoService;
import lotto.util.NumberGenerator;
import lotto.util.UniqueRandomNumbersGenerator;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Application {
    public static void main(String[] args) {
        InputView inputView = InputView.getInstance();
        OutputView outputView = OutputView.getInstance();
        LottoService lottoService = LottoService.getInstance();
        NumberGenerator numberGenerator = new UniqueRandomNumbersGenerator();
        LottoController lottoController = new LottoController(inputView, outputView, lottoService, numberGenerator);
        lottoController.run();
    }
}
