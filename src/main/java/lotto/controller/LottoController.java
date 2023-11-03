package lotto.controller;

import lotto.domain.LottoTickets;
import lotto.view.InputView;

import java.util.ArrayList;

public class LottoController {
    private final InputView inputView;
    private final LottoTickets lottoTickets;

    public LottoController() {
        this.inputView = new InputView();
        this.lottoTickets = new LottoTickets();
    }

    public void run() {
        Integer money = inputView.inputMoney();
        lottoTickets.buyLotto(money);

        ArrayList<Integer> winningNumber = inputView.winningNumber();


        Integer bonusNumber = inputView.bonusNumber(winningNumber);
    }
}
