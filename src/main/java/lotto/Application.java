package lotto;

import lotto.controller.LottoController;
import lotto.util.InputConverter;
import lotto.validation.InputValidator;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Application {
    public static void main(String[] args) {
        InputValidator inputValidator = new InputValidator();
        InputConverter inputConverter = new InputConverter();

        LottoController controller = LottoController.init(new InputView(inputValidator, inputConverter), new OutputView());
        controller.start();
    }
}
