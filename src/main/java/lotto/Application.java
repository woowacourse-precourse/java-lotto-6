package lotto;

import lotto.controller.LottoController;
import lotto.service.LottoService;
import lotto.view.InputView;

public class Application {
    public static void main(String[] args) {
        LottoController controller = new LottoController(
                new LottoService(),
                new InputView()
        );
        controller.play();
    }
}
