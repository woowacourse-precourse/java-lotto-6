package lotto;

import lotto.controller.LottoController;
import lotto.util.InputConverter;
import lotto.validation.InputValidator;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        LottoController lottoController = new LottoController(
            new InputView(new InputValidator(), new InputConverter()), new OutputView());

        lottoController.start();
    }
}
