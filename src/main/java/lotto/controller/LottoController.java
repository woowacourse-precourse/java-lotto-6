package lotto.controller;

import java.util.Objects;
import lotto.domain.LottoTickets;
import lotto.view.InputView;

public class LottoController {
    private final InputView inputView;

    public LottoController(InputView inputView) {
        this.inputView = Objects.requireNonNull(inputView);
    }
    public void run() {
        String purchaseMoney = inputView.requestPurchaseMoney();
        LottoTickets lottoTicket = LottoTickets.purchase(purchaseMoney);

        int lottoTicketQuantity = lottoTicket.getLottoTicketCount();
    }
}
