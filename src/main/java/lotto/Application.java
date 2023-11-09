package lotto;

import lotto.controller.GameManagerController;
import lotto.service.GameManagerService;
import lotto.service.LottoService;
import lotto.view.ConsoleInputView;
import lotto.view.ConsoleOutputView;

public class Application {
    public static void main(String[] args) {
        final GameManagerController gameManagerController = new GameManagerController(
                new ConsoleInputView(),
                new ConsoleOutputView(),
                new GameManagerService(),
                new LottoService());
        gameManagerController.start();
    }
}
