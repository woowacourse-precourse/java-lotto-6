package lotto;

import lotto.controller.LottoController;
import lotto.model.LottoTicket;
import lotto.view.LottoInputView;
import lotto.view.LottoOutputView;

public class Application {

    public static void main(String[] args) {
        LottoController controller = new LottoController(new LottoInputView(),
            new LottoOutputView());
        controller.play();
    }
}
