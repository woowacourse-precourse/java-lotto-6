package lotto;

import lotto.controller.Controller;
import lotto.view.Input;
import lotto.view.Output;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Controller controller = new Controller(new Output(), new Input());
        controller.run();

    }
}
