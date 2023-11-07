package lotto.controller;

import lotto.manager.StatisticsManager;

public class ProfitController {

    private final StatisticsManager statisticsManager = StatisticsManager.getInstance();

    public void handle() {
        statisticsManager.calculateProfit();
        statisticsManager.printProfit();
    }
}
