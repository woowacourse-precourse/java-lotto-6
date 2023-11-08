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

    private static Player player;

    public static GameController getGameController() {
        return new GameController(getPlayer(), getPlayerService(), getWinningNumberGenerator(), getOutputController(), getLottoCountGenerator());
    }

    private static PlayerService getPlayerService() {
        return new PlayerService(getPlayer(), getLottoGenerator(), getWinningLottoCalculator());
    }

    private static Player getPlayer() {
        if (player == null) {
            player = new Player(new CorrectLottoCalculator());
        }
        return player;
    }

    private static WinningNumberGenerator getWinningNumberGenerator(){
        return new WinningNumberGenerator();
    }

    private static LottoCountGenerator getLottoCountGenerator(){
        return new LottoCountGenerator();
    }

    private static LottoGenerator getLottoGenerator(){
        return new LottoGenerator();
    }

    private static WinningLottoCalculator getWinningLottoCalculator(){
        return new WinningLottoCalculator();
    }

    private static OutputController getOutputController() {
        return new OutputController(getTotalStatCalculator());
    }

    private static TotalStatCalculator getTotalStatCalculator(){
        return new TotalStatCalculator(getPlayer());
    }
}
