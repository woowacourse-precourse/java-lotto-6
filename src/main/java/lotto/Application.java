package lotto;

import lotto.controller.LottoController;
import lotto.handler.InputHandler;
import lotto.view.ConsoleInput;

public class Application {

    public static void main(String[] args) {

        final InputHandler inputHandler = new ConsoleInput();

        new LottoController(inputHandler).run();
    }
}
