package lotto;

import lotto.controller.Controller;
import lotto.view.InputView;
import lotto.view.UserInputView;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new UserInputView();
        Controller controller = new Controller(inputView);
        controller.start();
    }
}
