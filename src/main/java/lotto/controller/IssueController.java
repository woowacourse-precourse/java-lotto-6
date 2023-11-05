package lotto.controller;

import lotto.domain.LottoTickets;
import lotto.domain.Purchase;
import lotto.dto.LottoIssueResultDTO;
import lotto.view.OutputView;

public class IssueController {
    private final Purchase purchase;

    private IssueController(Purchase purchase) {
        this.purchase = purchase;
    }

    public static IssueController from(Purchase purchase) {
        return new IssueController(purchase);
    }

    public void issueTickets() {
        LottoIssueResultDTO result = buyLottoTickets();
        displayLottoTickets(result);
    }

    private LottoIssueResultDTO buyLottoTickets() {
        LottoTickets tickets = purchase.generateLottoTickets();
        return LottoIssueResultDTO.of(purchase.getTicketCount(), tickets.getTickets());
    }

    private void displayLottoTickets(LottoIssueResultDTO result) {
        OutputView.printLottoIssueResult(result);
    }
}
