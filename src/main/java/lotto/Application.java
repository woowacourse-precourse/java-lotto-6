package lotto;

import lotto.controller.LottoController;
import lotto.view.OutputView;

public class Application {
    public static void main(String[] args) {
        LottoController controller = new LottoController(new OutputView());
        controller.start();
    }
}
