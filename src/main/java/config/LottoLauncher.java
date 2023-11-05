package config;

import VO.UserLottoVO;
import controller.GameController;
import domain.WinningLotto;
import service.LottoService;
import view.GameView;
import view.InputView;

public class LottoLauncher {

    private static LottoLauncher defaultLottoLauncher;
    private InputView inputView;
    private GameController gameController;
    private LottoService lottoService;
    private WinningLotto winningLotto;
    private UserLottoVO userLottoVO;
    private GameView gameView;

    private LottoLauncher() {
    }

    public static LottoLauncher getInstance() {
        if(defaultLottoLauncher == null) {
            defaultLottoLauncher = new LottoLauncher();
        }
        return defaultLottoLauncher;
    }


}
