package lotto.view;

import lotto.controller.UserController;
import lotto.domain.User;

public class GameManager {
    UserController userController = new UserController(new User());

    public GameManager() {
    }

    public void startGame(){
        userController.savePayMoney();
        userController.showMyCount();
        userController.buyLottos();
        userController.predictWinningNumber();
        userController.predictBonusNumber();
        userController.showWinningResult();
        userController.showRateMoney();
    }
}
