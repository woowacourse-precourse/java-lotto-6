package lotto;

import lotto.controller.InputController;
import lotto.controller.OutputController;
import lotto.service.LottoGameService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        InputController inputController = new InputController(inputView);

        OutputView outputView = new OutputView();
        OutputController outputController = new OutputController(outputView);

        LottoGameService lottoGameService = new LottoGameService(inputController, outputController);
        lottoGameService.run();
    }
}