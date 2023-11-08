package lotto;

import lotto.controller.LottoGameController;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        LottoGameController lottoGameController = new LottoGameController(inputView, outputView);

        lottoGameController.run();
    }
}
