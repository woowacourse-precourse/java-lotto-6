package lotto;

import lotto.controller.LottoController;
import lotto.domain.LottoNumberGenerator;
import lotto.service.LottoPaymentService;
import lotto.view.ConsoleInputView;
import lotto.view.ConsoleResultView;

public class Application {
    public static void main(String[] args) {
        LottoController controller = new LottoController(
                new ConsoleInputView(),
                new ConsoleResultView(),
                new LottoPaymentService(),
                new LottoNumberGenerator()
        );
        controller.run();
    }
}
