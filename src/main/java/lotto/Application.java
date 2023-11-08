package lotto;

import lotto.Controller.LottoController;
import lotto.View.LottoInputView;
import lotto.View.LottoOutputView;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        LottoInputView inputView = new LottoInputView();
        LottoOutputView outputView = new LottoOutputView();
        LottoController controller = new LottoController(inputView, outputView);

        controller.runGame();
    }
}
