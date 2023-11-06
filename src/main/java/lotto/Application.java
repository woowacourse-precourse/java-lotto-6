package lotto;

import lotto.controller.LottoController;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Application {
    private static InputView inputView = new InputView();
    private static OutputView outputView = new OutputView();
    public static void main(String[] args) {
        LottoController lottoController = new LottoController(inputView, outputView);

        lottoController.run();
    }
}
