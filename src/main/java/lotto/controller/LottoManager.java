package lotto.controller;

import java.util.List;
import java.util.stream.IntStream;
import lotto.domain.Ticket;
import lotto.service.BonusNumberService;
import lotto.service.TicketService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoManager {

    private final TicketService ticketService;
    private final BonusNumberService bonusNumberService;

    public LottoManager(TicketService ticketService, BonusNumberService bonusNumberService) {
        this.ticketService = ticketService;
        this.bonusNumberService = bonusNumberService;
    }

    public void run() {
        purchaseTickets(InputView.purchaseAmount());
        winningTicket(InputView.winningNumbers());
        bonusNumber(InputView.bonusNumber(ticketService.getWinningTicket()));

        OutputView.displayStatistic(
                ticketService.prizeCount(),
                ticketService.getPurchaseAmount());
    }

    private void bonusNumber(String bonusNumber) {
        bonusNumberService.announcementBonusNumber(bonusNumber);
    }

    private void winningTicket(String numbers) {
        ticketService.announcementNumber(numbers);
    }

    private void purchaseTickets(String money) {
        int ticketCnt = ticketService.purchaseAmount(money);
        List<Ticket> tickets = IntStream.range(0, ticketCnt)
                .mapToObj(ticket -> ticketService.automaticPurchase())
                .toList();
        OutputView.displayTicket(tickets);
    }

}
