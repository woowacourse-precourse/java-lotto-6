package lotto;

import lotto.controller.GameController;
import lotto.controller.InputController;
import lotto.domain.service.KoreanMoneyService;
import lotto.domain.service.UserService;
import lotto.view.OutputView;

public class Application {
    public static void main(String[] args) {
        GameController gameController = new GameController(new InputController(new KoreanMoneyService()),new OutputView(),new UserService(),new KoreanMoneyService());
        gameController.startGame();
        gameController.showResult();
    }
}
