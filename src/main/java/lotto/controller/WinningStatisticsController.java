package lotto.controller;

import lotto.manager.IOManager;
import lotto.manager.StatisticsManager;

public class WinningStatisticsController {
    private final IOManager ioManager = IOManager.getInstance();
    private final StatisticsManager statisticsManager = StatisticsManager.getInstance();

    public void handle() {
        ioManager.printWinningStatisticsGuide();
        statisticsManager.calculateAllStatistics();
        statisticsManager.printWinningStatistics();
    }
}