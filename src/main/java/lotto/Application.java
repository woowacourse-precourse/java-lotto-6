package lotto;

import lotto.controller.LottoGameController;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Application {
    public static void main(String[] args) {

        LottoGameController controller = new LottoGameController(new InputView(), new OutputView());
        controller.run();
    }
}
