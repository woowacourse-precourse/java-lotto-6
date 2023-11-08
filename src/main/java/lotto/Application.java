package lotto;

import lotto.io.IOManager;
import lotto.io.input.ConsoleInputView;
import lotto.io.output.ConsoleOutputView;
import lotto.manager.GameController;
import lotto.manager.MoneyManager;
import lotto.model.lotto.Lotto;

public class Application {
    public static void main(String[] args) {
        IOManager ioManager = new IOManager(new ConsoleInputView(), new ConsoleOutputView());
        GameController gameController = new GameController(ioManager);
        gameController.run();
    }
}
