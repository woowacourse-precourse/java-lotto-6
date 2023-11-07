package lotto.controller;

import lotto.model.LottoTicket;
import lotto.view.GameResultOutputView;
import lotto.view.UserInputView;

public class GameController {
    public static void play() {
        LottoTicket lottoTicket = UserInputView.inputPurchaseAmount();
        GameResultOutputView.showLottoTickets(lottoTicket);
    }
}
