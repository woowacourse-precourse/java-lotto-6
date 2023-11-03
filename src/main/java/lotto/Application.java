package lotto;

import controller.UserController;
import view.InputView;

public class Application {

    static InputView inputView = new InputView();
    static UserController userController = new UserController();

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        int purchasePrice = userController.inputPriceHowManyLottos();
    }
}
