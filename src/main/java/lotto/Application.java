package lotto;

import lotto.controller.LottoController;
import lotto.io.InputView;
import lotto.io.LottoIoManager;
import lotto.io.OutputView;

public class Application {

    public static void main(String[] args) {
        LottoController lottoController = new LottoController(new InputView(new LottoIoManager()),
                new OutputView());

        lottoController.run();
    }
}
