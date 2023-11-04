package lotto.controller;

import lotto.domain.LottoOwner;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoGameController {
    public void play() {
        LottoOwner lottoOwner = new LottoOwner();
        purchaseLottoByOwner(lottoOwner);

    }

    private void purchaseLottoByOwner(LottoOwner lottoOwner) {
        while (true) {
            try {
                OutputView.printPurchasePriceInputText();
                int ticketNumber = lottoOwner.purchaseLotto(InputView.getUserInput());
                OutputView.printTicketNumber(ticketNumber);
                return;
            } catch (IllegalArgumentException e) {
                OutputView.printErrorMessage(e.getMessage());
            }
        }
    }


}
