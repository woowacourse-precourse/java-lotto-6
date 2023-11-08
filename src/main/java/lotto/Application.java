package lotto;

import lotto.controller.LottoGameController;
import lotto.Validation.InputValidator;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        InputValidator inputValidator = new InputValidator();
        InputView inputView = new InputView(inputValidator);
        OutputView outputView = new OutputView();

        LottoGameController lottoGameController = new LottoGameController(inputView, outputView);
        lottoGameController.run();
    }
}
