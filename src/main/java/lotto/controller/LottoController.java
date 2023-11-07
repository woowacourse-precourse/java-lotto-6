package lotto.controller;

import lotto.domain.TicketAmount;
import lotto.view.OutputView;

public class LottoController {
    private TicketAmount ticketAmount;
    private int ticketCount;

    public void run() {
        setTicketAmountAndCount();
    }

    private void setTicketAmountAndCount() {
        OutputView.printMoneyInputMessage();
        ticketAmount = InputController.setTicketAmount();
        ticketCount = ticketAmount.calculateTicketAmount();
    }
}