package lotto;

import lotto.controller.LottoController;
import lotto.exception.InputExceptionTemplate;
import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Application {
    public static void main(String[] args) {
        LottoController controller = new LottoController(
                new LottoService(
                        new InputExceptionTemplate()
                ),
                new InputView(),
                new OutputView()
        );
        controller.play();
    }
}
