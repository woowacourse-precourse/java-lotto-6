package lotto;

import lotto.controller.GameController;
import lotto.service.GameService;
import lotto.util.InputValueChecker;
import lotto.util.LottoNumberFactory;
import lotto.view.input.ConsoleInput;
import lotto.view.input.InputView;
import lotto.view.output.ConsoleOutputView;

public class Application {
    public static void main(String[] args) {
        GameController gameController = new GameController(new ConsoleOutputView(),
                new InputView(new ConsoleInput(), new InputValueChecker()),
                new GameService(new LottoNumberFactory()));

        gameController.startGame();
    }
}
