package lotto.controller;

import lotto.domain.TicketAmount;
import lotto.view.OutputView;

public class LottoController {
    private TicketAmount ticketAmount;
    
    public void run() {
        setTicketAmountAndCount();
    }

    private void setTicketAmountAndCount() {
        OutputView.printMoneyInputMessage();
        ticketAmount = InputController.setTicketAmount();
    }
}