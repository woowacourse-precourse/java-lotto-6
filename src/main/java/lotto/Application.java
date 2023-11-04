package lotto;

import lotto.controller.LottoController;
import lotto.view.console.ConsoleInputView;
import lotto.view.console.ConsoleOutputView;

public class Application {
    public static void main(String[] args) {
        new LottoController(
                new ConsoleInputView(),
                new ConsoleOutputView()
        ).run();
    }
}
