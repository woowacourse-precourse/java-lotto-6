package lotto.controller;

import lotto.view.LottoInputView;

public class LottoController {

    private final LottoInputView lottoInputView = new LottoInputView();

    public void run() {
        buyLottoTicketProcess();
    }

    private void buyLottoTicketProcess() {
        lottoInputView.getLottoPurchaseAmountInput();
    }

}
