package lotto;

import lotto.controller.LottoController;
import lotto.view.InputDevice;
import lotto.view.InputView;

public class Application {
    public static void main(String[] args) {
        LottoController lottoController = new LottoController(
                new InputView(new InputDevice())
        );
        lottoController.play();
    }
}
