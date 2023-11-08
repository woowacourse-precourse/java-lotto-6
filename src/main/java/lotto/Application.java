package lotto;

import lotto.Controller.Controller;
import lotto.Utils.InputSystem;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Controller controller = new Controller();
        controller.startPurchase();
        controller.decideWinningLotto(InputSystem.inputWinningNumbers());
        controller.calculateWinning();
        controller.printResult();
    }
}