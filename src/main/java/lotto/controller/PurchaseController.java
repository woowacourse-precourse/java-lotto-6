package lotto.controller;

import lotto.manager.AppManager;
import lotto.manager.IOManager;
import lotto.manager.PublishManager;
import lotto.manager.StatisticsManager;

public class PurchaseController {

    private final AppManager appManager = AppManager.getInstance();
    private final PublishManager publishManager = PublishManager.getInstance();
    private final StatisticsManager statisticsManager = StatisticsManager.getInstance();
    private final IOManager ioManager = IOManager.getInstance();

    public void handle() {
        ioManager.printPayAmountInputGuide();
        int payAmount = Integer.MIN_VALUE;

        try {
            payAmount = ioManager.readPayAmount();
        } catch (IllegalArgumentException e) {
            ioManager.printExceptionMessage(e.getMessage());
            appManager.handleInvalidInput(this.getClass().getName());
        }

        statisticsManager.setPayAmount(payAmount);
        publishManager.generateTickets(payAmount);
        publishManager.printTicketCount();
    }
}
