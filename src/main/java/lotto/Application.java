package lotto;

import lotto.controller.GameController;
import lotto.handler.InputHandler;
import lotto.service.LottoService;
import lotto.utils.DefaultLottoWinningStrategy;
import lotto.utils.LottoFormatter;
import lotto.utils.RandomNumberGenerator;
import lotto.view.GameView;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        GameController gameController = new GameController(new GameView(new LottoFormatter()), new InputHandler(), new LottoService(new DefaultLottoWinningStrategy(), new RandomNumberGenerator()));
        gameController.startGame();
    }
}
