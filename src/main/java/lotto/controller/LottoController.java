package lotto.controller;

import lotto.model.collections.LottoPurchaseAmount;
import lotto.model.collections.LottoTicketCount;
import lotto.service.LottoTicketService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private final LottoTicketService lottoTicketService;

    public LottoController(LottoTicketService lottoTicketService) {
        this.lottoTicketService = lottoTicketService;
    }

    public void run(){
        OutputView.printPurchaseAmountMessage();
        LottoPurchaseAmount purchaseAmount = lottoTicketService.parsePurchaseAmount(InputView.read());
        LottoTicketCount ticketCount = lottoTicketService.convertMoneyToTickets(purchaseAmount);
    }
}
