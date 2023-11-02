package lotto.controller;

import static lotto.view.constant.Message.*;

import java.util.Objects;
import lotto.domain.LottoTickets;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private final InputView inputView;
    private final OutputView outputView;

    public LottoController(InputView inputView, OutputView outputView) {
        this.inputView = Objects.requireNonNull(inputView);
        this.outputView = Objects.requireNonNull(outputView);
    }
    public void run() {
        String purchaseMoney = inputView.requestPurchaseMoney();
        LottoTickets lottoTicket = LottoTickets.purchase(purchaseMoney);

        int lottoTicketQuantity = lottoTicket.getLottoTicketCount();
        outputView.printDynamicMessage(NOTICE_PURCHASE_QUANTITY, lottoTicketQuantity);
    }
}
