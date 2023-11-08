package lotto;

import lotto.domain.game.GameController;
import lotto.global.config.Dependency;
import lotto.global.view.output.OutputView;

import static lotto.global.constant.exception.ExceptionMessage.EXCEPTION_PREFIX;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        try {
            Dependency dependency = new Dependency();
            GameController gameController = dependency.gameController();
            gameController.play();
        } catch (Exception e) {
            OutputView.printMessageLine(EXCEPTION_PREFIX.getMessage() + e.getMessage());
        }

    }
}
