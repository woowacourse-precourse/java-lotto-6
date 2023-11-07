package lotto.controller;

import lotto.domain.LottoTickets;
import lotto.domain.Purchase;
import lotto.dto.output.LottoIssueResultDTO;
import lotto.view.console.OutputView;

public class IssueController {
    private final Purchase purchase;

    private IssueController(Purchase purchase) {
        this.purchase = purchase;
    }

    public static IssueController from(Purchase purchase) {
        return new IssueController(purchase);
    }

    public LottoTickets issueTickets() {
        LottoTickets tickets = buyLottoTickets();
        displayLottoTickets(tickets);
        return tickets;
    }

    private LottoTickets buyLottoTickets() {
        return purchase.generateLottoTickets();
    }

    private void displayLottoTickets(LottoTickets tickets) {
        LottoIssueResultDTO result = LottoIssueResultDTO.of(purchase.getTicketCount(), tickets.getTickets());
        OutputView.printLottoIssueResult(result);
    }
}
