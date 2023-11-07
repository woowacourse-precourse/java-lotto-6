package lotto.controller;

import lotto.domain.LottoTickets;
import lotto.domain.TicketAmount;
import lotto.view.OutputView;

public class LottoController {
    private TicketAmount ticketAmount;
    private int ticketCount;

    public void run() {
        setTicketAmountAndCount();
        setLottoTickets();
    }

    private void setTicketAmountAndCount() {
        OutputView.printMoneyInputMessage();
        ticketAmount = InputController.setTicketAmount();
        ticketCount = ticketAmount.calculateTicketAmount();
    }

    private void setLottoTickets() {
        LottoTickets lottoTickets = new LottoTickets(ticketCount);
    }
}