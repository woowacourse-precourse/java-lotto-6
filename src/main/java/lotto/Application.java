package lotto;

import lotto.controller.Controller;
import lotto.domain.LottoGenerator;
import lotto.domain.RandomLottoGenerator;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Application {

    public static void main(String[] args) {
        Controller controller = new Controller(initInputView(), initOutPutView(), initLottoGenerator());
        controller.run();
    }

    private static InputView initInputView() {
        return InputView.create();
    }

    private static OutputView initOutPutView() {
        return OutputView.create();
    }

    private static LottoGenerator initLottoGenerator() {
        return RandomLottoGenerator.create();
    }
}
