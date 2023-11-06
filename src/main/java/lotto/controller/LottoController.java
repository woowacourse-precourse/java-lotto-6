package lotto.controller;

import lotto.domain.LottoTicket;
import lotto.domain.PurchaseAmount;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    public void start() {
        PurchaseAmount purchaseAmount = readAmount();
        LottoTicket lottoTicket = buyTicket(purchaseAmount);
    }

    private PurchaseAmount readAmount() {
        try {
            return new PurchaseAmount(InputView.readPurchaseAmount());
        } catch (IllegalArgumentException e) {
            OutputView.printException(e);
            return readAmount();
        }
    }


    private LottoTicket buyTicket(PurchaseAmount purchaseAmount) {
        int lottoCount = purchaseAmount.calculateLottoCount();
        OutputView.printLottoCount(lottoCount);

        LottoTicket lottoTicket = new LottoTicket(lottoCount);
        OutputView.printTicket(lottoTicket);
        return lottoTicket;
    }

}
