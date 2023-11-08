package lotto.controller;

import lotto.domain.LottoTicket;
import lotto.domain.LottoTicketFactory;
import lotto.domain.PurchaseAmount;
import lotto.utils.Parser;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Controller {

    public void run() {
        PurchaseAmount purchaseAmount = getPurchaseAmount();
        LottoTicket lottoTicket = buyTicket(purchaseAmount.getPurchaseCount());
        printPurchaseLottoResult(lottoTicket);
    }

    private PurchaseAmount getPurchaseAmount() {
        try {
            return PurchaseAmount.of(Parser.parseToInt(InputView.getPurchaseAmountInput()));
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e.getMessage());
            return getPurchaseAmount();
        }
    }

    private LottoTicket buyTicket(int purchaseLottoCount) {
        return LottoTicketFactory.generateTicket(purchaseLottoCount);
    }

    private void printPurchaseLottoResult(LottoTicket ticket) {
        OutputView.printPurchaseLottoResult(ticket);
    }

}


