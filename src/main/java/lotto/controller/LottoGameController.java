package lotto.controller;

import lotto.domain.LottoOwner;
import lotto.domain.LottoTicket;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoGameController {
    public void play() {
        LottoTicket lottoTicket = purchaseLotto();
        LottoOwner lottoOwner = generateLotto(lottoTicket);

    }

    private LottoOwner generateLotto(LottoTicket lottoTicket) {
        LottoOwner lottoOwner = new LottoOwner(lottoTicket);
        OutputView.printLottoNumbers(lottoOwner.getLottoNumbers());
        return lottoOwner;
    }

    private LottoTicket purchaseLotto() {
        LottoTicket lottoTicket;
        while (true) {
            try {
                OutputView.printPurchasePriceInputText();
                lottoTicket = new LottoTicket(InputView.getUserInput());
                OutputView.printTicketNumber(lottoTicket.getTicketNumber());
                return lottoTicket;
            } catch (IllegalArgumentException e) {
                OutputView.printErrorMessage(e.getMessage());
            }
        }
    }


}
