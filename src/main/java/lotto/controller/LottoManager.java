package lotto.controller;

import java.util.List;
import java.util.stream.IntStream;
import lotto.domain.Ticket;
import lotto.service.TicketSevice;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoManager {

    private final TicketSevice ticketSevice;

    public LottoManager(TicketSevice ticketSevice) {
        this.ticketSevice = ticketSevice;
    }

    public void run() {
        purchaseTickets(InputView.purchaseAmount());
    }

    private void purchaseTickets(Integer money) {
        int ticketCnt = ticketSevice.purchaseAmount(money);
        List<Ticket> tickets = IntStream.range(0, ticketCnt)
                .mapToObj(ticket -> ticketSevice.automaticPurchase())
                .toList();
        OutputView.displayTicket(tickets);
    }


}
