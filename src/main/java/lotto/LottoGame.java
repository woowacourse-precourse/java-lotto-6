package lotto;

import lotto.controller.LottoMakingController;
import lotto.controller.StatisticsController;
import lotto.domain.Lotto;
import lotto.domain.Player;

public class LottoGame {
    private final LottoMakingController gameSetting = new LottoMakingController();
    private final StatisticsController gameResult = new StatisticsController();

    public void start() {
        gameSetting.createLottoCount();
    }

}
