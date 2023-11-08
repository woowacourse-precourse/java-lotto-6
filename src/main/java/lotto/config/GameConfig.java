package lotto.config;

import lotto.controller.GameController;
import lotto.controller.OutputController;
import lotto.domain.Player;
import lotto.service.CorrectLottoCalculator;
import lotto.service.LottoCountGenerator;
import lotto.service.LottoGenerator;
import lotto.service.PlayerService;
import lotto.service.TotalStatCalculator;
import lotto.service.WinningLottoCalculator;
import lotto.service.WinningNumberGenerator;

public class GameConfig {

    public static GameController getGameController() {
        CorrectLottoCalculator correctLottoCalculator = new CorrectLottoCalculator();
        Player player = new Player(correctLottoCalculator);
        PlayerService playerService = getPlayerService(player);
        OutputController outputController = getOutputController(player);
        WinningNumberGenerator winningNumberGenerator = new WinningNumberGenerator();
        LottoCountGenerator lottoCountGenerator = new LottoCountGenerator();

        return new GameController(player, playerService, winningNumberGenerator, outputController, lottoCountGenerator);
    }

    private static PlayerService getPlayerService(Player player) {
        LottoGenerator lottoGenerator = new LottoGenerator();
        WinningLottoCalculator winningLottoCalculator = new WinningLottoCalculator();

        return new PlayerService(player, lottoGenerator, winningLottoCalculator);
    }

    private static OutputController getOutputController(Player player) {
        TotalStatCalculator totalStatCalculator = new TotalStatCalculator(player);

        return new OutputController(totalStatCalculator);
    }
}
