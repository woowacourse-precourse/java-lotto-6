package lotto.controller;

import lotto.domain.LottoTicket;
import lotto.view.input.AmountInputView;
import lotto.view.input.InputView;

public class Controller {

    public void buyLotto() {
        InputView<Integer> amountInputView = new AmountInputView<>(Integer::parseInt);
        int amount = amountInputView.getInput();

        LottoTicket lottoTicket = new LottoTicket();
        lottoTicket.createLottoTicket(amount);
    }


}
