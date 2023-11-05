package lotto;

import lotto.controller.InputController;
import lotto.controller.LottoGameService;
import lotto.controller.OutputController;
import lotto.view.InputValidator;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Application {
    public static void main(String[] args) {
        InputValidator inputValidator = new InputValidator();
        InputView inputView = new InputView(inputValidator);
        OutputView outputView = new OutputView();
        InputController inputController = new InputController(inputView);
        OutputController outputController = new OutputController(outputView);

        LottoGameService lottoGameService = new LottoGameService(inputController, outputController);
        lottoGameService.run();
    }
}