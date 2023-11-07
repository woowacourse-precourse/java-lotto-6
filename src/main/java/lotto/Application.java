package lotto;

import lotto.controller.GameMainController;
import lotto.domain.RandomNumberGenerator;
import lotto.service.GameService;
import lotto.validation.InputValidator;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Application {
    public static void main(String[] args) {
            GameMainController gameMainController = new GameMainController
                    (new GameService(new RandomNumberGenerator()), new InputView(new InputValidator()), new OutputView());
            gameMainController.run();
    }
}
