package lotto.controller;

import lotto.manager.AppManager;
import lotto.manager.IOManager;
import lotto.manager.LottoManager;

public class WinningStatisticsController {

    private final AppManager appManager = new AppManager();
    private final LottoManager lottoManager = LottoManager.getInstance();
    private final IOManager ioManager = new IOManager();

    public void handle() {
        ioManager.printWinningStatisticsGuide();
        lottoManager.calculateAllLotto();
        ioManager.printWinningStatistics();
    }

}
