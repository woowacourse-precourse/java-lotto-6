package lotto;

import lotto.controller.LottoController;
import lotto.view.InputView;
import lotto.view.OutputView;
import lotto.view.util.InputUtil;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new InputView(new InputUtil());
        OutputView outputView = new OutputView();
        LottoController lottoController = new LottoController(inputView, outputView);
        lottoController.run();
    }
}
