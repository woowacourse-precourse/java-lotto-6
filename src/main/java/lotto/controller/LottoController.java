package lotto.controller;

import java.util.EnumMap;
import java.util.List;
import lotto.domain.Prize;
import lotto.domain.Ticket;
import lotto.io.Input;
import lotto.io.Output;
import lotto.service.TicketService;

public class LottoController {
    public static void run() {
        Ticket ticket = getTicket();
        List<Integer> winningNumbers = Input.winningNumbers();
        int bonusNumber = Input.bonusNumber(winningNumbers);
        printResult(ticket, winningNumbers, bonusNumber);
    }

    private static Ticket getTicket() {
        int purchaseAmount = Input.purchaseAmount();
        Ticket ticket = TicketService.createTicket(purchaseAmount);
        Output.printTicket(ticket);
        return ticket;
    }

    private static void printResult(Ticket ticket, List<Integer> winningNumbers, int bonusNumber) {
        EnumMap<Prize, Integer> statistics = TicketService.getStatistics(ticket, winningNumbers, bonusNumber);
        Output.printStatistics(statistics);
        Output.printProfitRate(ticket, winningNumbers, bonusNumber);
    }
}
