package lotto;

import lotto.controller.GameController;
import lotto.service.GameService;
import lotto.util.LottoNumberFactory;
import lotto.view.input.ConsoleInputView;
import lotto.view.output.ConsoleOutputView;

public class Application {
    public static void main(String[] args) {
        GameController gameController = new GameController(new ConsoleInputView(),
                new ConsoleOutputView(),
                new LottoNumberFactory(), new GameService());

        gameController.startGame();
    }
}
