package lotto.controller;

import lotto.manager.AppManager;
import lotto.manager.IOManager;
import lotto.manager.LottoManager;

public class BuyingController {

    private final AppManager appManager = new AppManager();
    private final LottoManager lottoManager = LottoManager.getInstance();
    private final IOManager ioManager = new IOManager();

    public void handle() {

        ioManager.printPayAmountInputGuide();
        int payAmount = Integer.MIN_VALUE;

        try {
            payAmount = ioManager.readPayAmount();
        } catch (IllegalArgumentException e) {
            ioManager.printExceptionMessage(e.getMessage());
            String className = this.getClass().getName();
            appManager.handleInvalidInput(className);
        }

        int lottoTicketsCount = lottoManager.generateLottoTickets(payAmount);
        lottoManager.setLottoTicketCount(lottoTicketsCount);
        ioManager.printLottoTicketCount(lottoManager.getLottoTicketCount());
    }
}
