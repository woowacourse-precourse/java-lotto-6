package lotto.controller;

import lotto.manager.AppManager;
import lotto.manager.IOManager;
import lotto.manager.StatisticsManager;

import java.util.List;

public class WinningNumberController {

    private final AppManager appManager = AppManager.getInstance();
    private final StatisticsManager statisticsManager = StatisticsManager.getInstance();
    private final IOManager ioManager = IOManager.getInstance();

    public void handle() {
        ioManager.printWiningNumberInputGuide();

        try {
            List<Integer> winningNumber = ioManager.readWinningNumber();
            statisticsManager.setWinningNumber(winningNumber);
        } catch (IllegalArgumentException e ) {
            ioManager.printExceptionMessage(e.getMessage());
            appManager.handleInvalidInput(this.getClass().getName());
        }
    }
}
