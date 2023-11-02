package lotto.controller;

import lotto.domain.LottoTicket;
import lotto.view.InputView;

public class LottoGameController {
    public void play() {
        LottoTicket lottoTicket = new LottoTicket(InputView.getUserInput());
    }
}
