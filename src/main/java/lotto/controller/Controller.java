package lotto.controller;

import lotto.domain.*;
import lotto.utils.Parser;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Controller {

    public void run() {
        PurchaseAmount purchaseAmount = getPurchaseAmount();
        LottoTicket lottoTicket = buyTicket(purchaseAmount.getPurchaseCount());
        printPurchaseLottoResult(lottoTicket);
        WinningLotto winningLotto = new WinningLotto(getWinningLotto());
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

    private Lotto getWinningLotto() {
        try {
            return new Lotto(Parser.parseToIntegers(InputView.getWinningNumbersInput()));
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e.getMessage());
            return getWinningLotto();
        }
    }
}


