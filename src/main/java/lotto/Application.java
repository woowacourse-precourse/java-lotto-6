package lotto;

import lotto.controller.LottoController;
import lotto.handler.InputHandler;
import lotto.handler.OutputHandler;
import lotto.view.ConsoleInput;
import lotto.view.ConsoleOutput;

public class Application {

    public static void main(String[] args) {

        final InputHandler inputHandler = new ConsoleInput();
        final OutputHandler outputHandler = new ConsoleOutput();

        new LottoController(inputHandler, outputHandler).run();
    }
}
