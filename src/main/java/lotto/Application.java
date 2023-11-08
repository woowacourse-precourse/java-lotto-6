package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import lotto.controller.GameController;
import lotto.service.GameService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new InputView(Console::readLine);
        OutputView outputView = new OutputView();
        GameService gameService = new GameService(Randoms::pickUniqueNumbersInRange);

        GameController gameController = new GameController(inputView, outputView, gameService);
        gameController.startGame();
    }
}
