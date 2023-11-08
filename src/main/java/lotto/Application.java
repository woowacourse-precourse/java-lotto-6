package lotto;

import lotto.controller.LottoController;
import lotto.view.ConsoleInputView;
import lotto.view.ConsoleOutputView;
import lotto.validator.InputValidator;

public class Application {
    public static void main(String[] args) {
        LottoController lottoController = new LottoController(
                ConsoleInputView.getInstance(), ConsoleOutputView.getInstance(), InputValidator.getInstance());
        lottoController.startLotto();
    }
}
