package lotto;

import lotto.controller.LottoController;
import lotto.domain.LottoNumberGenerator;
import lotto.domain.LottoPayment;
import lotto.view.ConsoleInputView;

public class Application {
    public static void main(String[] args) {
        LottoController controller = new LottoController(
                new ConsoleInputView(),
                new LottoPayment(),
                new LottoNumberGenerator()
        );
        controller.run();
    }
}
