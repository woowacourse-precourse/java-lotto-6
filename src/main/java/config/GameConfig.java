package config;

import VO.UserLottoVO;
import controller.GameController;
import domain.WinningLotto;
import service.LottoService;
import view.GameView;
import view.InputView;

public class GameConfig {

    private static GameConfig defaultGameConfig;
    private InputView inputView;
    private GameController gameController;
    private LottoService lottoService;
    private UserLottoVO userLottoVO;
    private GameView gameView;

    private GameConfig() {
    }

    public static GameConfig getInstance() {
        if(defaultGameConfig == null) {
            defaultGameConfig = new GameConfig();
        }
        return defaultGameConfig;
    }

    public GameView gameView() {
        if(gameView == null) {
            gameView = new GameView();
        }
        return gameView;
    }

    public UserLottoVO userLottoVO() {
        if(userLottoVO == null) {
            userLottoVO = new UserLottoVO();
        }
        return userLottoVO;
    }

    public WinningLotto winningLotto() {
        return WinningLotto.getInstance();
    }

    public LottoService lottoService() {
        if(lottoService == null) {
            lottoService = new LottoService(winningLotto(),userLottoVO());
        }
        return lottoService;
    }

    public GameController gameController() {
        if(gameController == null) {
            gameController = new GameController(lottoService(),gameView());
        }
        return gameController;
    }

    public InputView inputView() {
        if(inputView == null) {
            inputView = new InputView(gameController());
        }
        return inputView;
    }
}
