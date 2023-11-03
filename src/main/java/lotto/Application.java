package lotto;

import controller.LottoController;
import view.InputView;
import view.OutputView;

public class Application {

    public static void main(String[] args) {
        LottoController controller = new LottoController(new InputView(), new OutputView());
        controller.run();
    }
}
