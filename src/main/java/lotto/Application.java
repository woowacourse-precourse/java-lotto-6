package lotto;

import View.ConsoleInputView;
import controller.Controller;

public class Application {
    public static void main(String[] args) {
        Controller lottoController = new Controller(new LottoMachine(), new ConsoleInputView());
        lottoController.run();
    }
}
