package lotto;

import lotto.controller.GameController;
import lotto.handler.InputHandler;
import lotto.service.LottoService;
import lotto.utils.DefaultLottoWinningStrategy;
import lotto.utils.LottoWinningStrategy;
import lotto.utils.NumberGenerator;
import lotto.utils.RandomNumberGenerator;
import lotto.view.GameView;

public class GameConfig {
    public GameController gameController() {
        return new GameController(gameView(), inputHandler(), lottoService());
    }
    private GameView gameView() {
        return new GameView();
    }
    private InputHandler inputHandler() {
        return new InputHandler();
    }
    private LottoService lottoService() {
        return new LottoService(lottoWinningStrategy(), numberGenerator());
    }
    private LottoWinningStrategy lottoWinningStrategy() {
        return new DefaultLottoWinningStrategy();
    }
    private NumberGenerator numberGenerator() {
        return new RandomNumberGenerator();
    }
}
