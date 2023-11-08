package lotto;

import lotto.Controller.Controller;
import lotto.Controller.MainController;

public class Application {
    public static void main(String[] args) {
        Controller mainController = new MainController();
        mainController.run();
    }
}
