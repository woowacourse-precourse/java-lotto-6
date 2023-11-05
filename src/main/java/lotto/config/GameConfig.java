package lotto.config;

import lotto.controller.GameController;
import lotto.controller.InputController;
import lotto.domain.Player;
import lotto.service.LottoGenerator;
import lotto.service.PlayerService;
import lotto.service.WinningLottoCalculator;

public class GameConfig {

    private static final int LOTTO_PRICE = 1000;

    public static GameController getGameController() {
        PlayerService playerService = getPlayerService();
        int lottoCount = getLottoCount();

        return new GameController(playerService, lottoCount);
    }

    private static PlayerService getPlayerService() {
        Player player = new Player();
        LottoGenerator lottoGenerator = new LottoGenerator();
        WinningLottoCalculator winningLottoCalculator = new WinningLottoCalculator();

        return new PlayerService(player, lottoGenerator, winningLottoCalculator);
    }

    private static int getLottoCount() {
        int customerPrice = InputController.inputPrice();

        return customerPrice/LOTTO_PRICE;
    }
}
