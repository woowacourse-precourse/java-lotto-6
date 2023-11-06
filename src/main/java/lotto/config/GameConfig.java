package lotto.config;

import lotto.controller.GameController;
import lotto.controller.InputController;
import lotto.domain.Player;
import lotto.domain.WinningNumbers;
import lotto.service.LottoGenerator;
import lotto.service.PlayerService;
import lotto.service.WinningLottoCalculator;
import lotto.service.WinningNumberGenerator;

public class GameConfig {

    private static final int LOTTO_PRICE = 1000;

    public static GameController getGameController() {
        PlayerService playerService = getPlayerService();
        WinningNumberGenerator winningNumberGenerator = new WinningNumberGenerator();
        int lottoCount = getLottoCount();

        return new GameController(playerService, winningNumberGenerator, lottoCount);
    }

    private static PlayerService getPlayerService() {
        Player player = new Player();
        LottoGenerator lottoGenerator = new LottoGenerator();
        WinningNumberGenerator winningNumberGenerator = new WinningNumberGenerator();
        WinningNumbers winningNumbers = winningNumberGenerator.generate();
        WinningLottoCalculator winningLottoCalculator = new WinningLottoCalculator();


        return new PlayerService(player, lottoGenerator, winningLottoCalculator);
    }

    private static int getLottoCount() {
        int customerPrice = InputController.inputPrice();

        return customerPrice/LOTTO_PRICE;
    }
}
