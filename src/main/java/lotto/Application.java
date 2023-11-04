package lotto;

import lotto.controller.Controller;
import lotto.view.ConsoleInputView;
import lotto.view.ConsoleOutputView;

public class Application {

    public static void main(String[] args) {
        Controller controller = new Controller(new ConsoleOutputView(), new ConsoleInputView());
        controller.run();
    }
}
