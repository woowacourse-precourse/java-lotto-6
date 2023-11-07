package lotto;

import lotto.controller.MainController;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Application {
    public static void main(String[] args) {
        MainController mainController = new MainController(new InputView(), new OutputView());
        mainController.start();
    }
}
