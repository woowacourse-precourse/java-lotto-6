package lotto;

import lotto.controller.GameController;
import lotto.handler.InputHandler;
import lotto.service.GameService;
import lotto.service.LottoService;
import lotto.utils.DefaultLottoWinningStrategy;
import lotto.utils.LottoWinningStrategy;
import lotto.utils.NumberGenerator;
import lotto.utils.RandomNumberGenerator;
import lotto.view.GameInputView;
import lotto.view.GameOutputView;

public class GameConfig {
    public GameController gameController() {
        return new GameController(gameService(), gameOutputView());
    }

    private GameService gameService() {
        return new GameService(gameInputView(), inputHandler(), lottoService());
    }
    private GameInputView gameInputView() {
        return new GameInputView();
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

    private GameOutputView gameOutputView() {
        return new GameOutputView();
    }
}
