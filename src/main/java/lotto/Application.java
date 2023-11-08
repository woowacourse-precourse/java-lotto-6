package lotto;

import lotto.cotroller.InputController;
import lotto.cotroller.MainController;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        MainController mainController = new MainController(
                new InputController(new InputView()),
                new OutputView()
        );
        mainController.run();
    }
}
