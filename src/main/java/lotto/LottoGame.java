package lotto;

import lotto.controller.LottoMakingController;
import lotto.controller.StatisticsController;
import lotto.domain.Lotto;
import lotto.domain.Player;

import java.util.ArrayList;

public class LottoGame {
    private final LottoMakingController gameSetting = new LottoMakingController();
    private final StatisticsController gameResult = new StatisticsController();
    private Player player;

    public void start() {
        gameSetting.createLottoCount();
        gameSetting.createLottos();
        gameSetting.createWinningNumbers();
        gameSetting.createBonusNumber();
        Player player = new Player(gameSetting.getLottos(), gameSetting.getWinningNumbers(), gameSetting.getBonusNumber(), gameSetting.getPayment());
        gameResult.CountWinningNumber(player);
    }

}
