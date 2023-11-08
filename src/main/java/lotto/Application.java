package lotto;

import lotto.control.Controller;
import lotto.view.Output;

public class Application {

    public static void main(String[] args) {
        Output output = new Output();
        Controller controller = new Controller();
        try {
            controller.start();
        } catch (IllegalArgumentException e) {
            output.printError(e);
        }
    }
}
