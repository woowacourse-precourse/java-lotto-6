package lotto.controller;

import lotto.Lotto;
import lotto.view.View;
import lotto.vo.BonusNumber;
import lotto.vo.TicketQuantity;

public class LottoGameController {

    private final View view;

    public LottoGameController(View view) {
        this.view = view;
    }

    public void run() {
        TicketQuantity ticketQuantity = view.getTicketQuantity();
        Lotto winningLotto = view.getWinningLotto();
        BonusNumber bonusNumber = view.getBonusNumber(winningLotto.getNumbers());
    }
}
