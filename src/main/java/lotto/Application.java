package lotto;

import lotto.controller.GameMainController;
import lotto.service.GameService;
import lotto.validation.InputValidator;
import lotto.view.InputView;

public class Application {
    public static void main(String[] args) {
        try {
            GameMainController gameMainController
                    = new GameMainController(new GameService(), new InputView(new InputValidator()));
            gameMainController.run();
        } catch (IllegalStateException e) {
            System.out.println(e.getMessage());
        }
    }
}
