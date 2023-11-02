package lotto.controller;

import lotto.domain.LottoTicket;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoGameController {
    public void play() {
        OutputView.printPurchasePriceInputText();
        LottoTicket lottoTicket = new LottoTicket(InputView.getUserInput());
        OutputView.printTicketNumber(lottoTicket.getTicketNumber());
    }
}
