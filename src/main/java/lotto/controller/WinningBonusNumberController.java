package lotto.controller;

import lotto.manager.AppManager;
import lotto.manager.IOManager;
import lotto.manager.StatisticsManager;

public class WinningBonusNumberController {

    private final AppManager appManager = AppManager.getInstance();
    private final StatisticsManager statisticsManager = StatisticsManager.getInstance();
    private final IOManager ioManager = IOManager.getInstance();

    public void handle() {
        ioManager.printWinningBonusNumberInputGuide();

        try {
            int winningBonusNumber = ioManager.readWinningBonusNumber();
            statisticsManager.setBonusNumber(winningBonusNumber);
        } catch(IllegalArgumentException e) {
            ioManager.printExceptionMessage(e.getMessage());
            appManager.handleInvalidInput(this.getClass().getName());
        }
    }
}
