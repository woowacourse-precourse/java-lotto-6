package lotto.controller;

import java.util.List;
import java.util.stream.IntStream;
import lotto.domain.Ticket;
import lotto.service.TicketService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoManager {

    private final TicketService ticketService;

    public LottoManager(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    public void run() {
        purchaseTickets(InputView.purchaseAmount());
    }

    private void purchaseTickets(Integer money) {
        int ticketCnt = ticketService.purchaseAmount(money);
        List<Ticket> tickets = IntStream.range(0, ticketCnt)
                .mapToObj(ticket -> ticketService.automaticPurchase())
                .toList();
        OutputView.displayTicket(tickets);
    }

}
