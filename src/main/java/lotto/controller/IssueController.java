package lotto.controller;

import lotto.domain.LottoPurchase;
import lotto.domain.LottoTickets;
import lotto.dto.output.LottoIssueResultDTO;
import lotto.view.console.OutputView;

public class IssueController {
    private final LottoPurchase lottoPurchase;

    private IssueController(LottoPurchase lottoPurchase) {
        this.lottoPurchase = lottoPurchase;
    }

    public static IssueController from(LottoPurchase lottoPurchase) {
        return new IssueController(lottoPurchase);
    }

    public LottoTickets issueTickets() {
        LottoTickets tickets = buyLottoTickets();
        displayLottoTickets(tickets);
        return tickets;
    }

    private LottoTickets buyLottoTickets() {
        return lottoPurchase.generateTickets();
    }

    private void displayLottoTickets(LottoTickets tickets) {
        LottoIssueResultDTO result = LottoIssueResultDTO.of(lottoPurchase.getTicketCount(), tickets.getTickets());
        OutputView.printLottoIssueResult(result);
    }
}
