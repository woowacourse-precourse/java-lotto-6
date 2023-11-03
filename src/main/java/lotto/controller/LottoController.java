package lotto.controller;

import lotto.service.LottoService;
import lotto.view.LottoInputView;

public class LottoController {

    private final LottoInputView lottoInputView = new LottoInputView();
    private final LottoService lottoService = new LottoService();

    public void run() {
        buyLottoTicketProcess();
    }

    private void buyLottoTicketProcess() {
        Long amount = lottoInputView.getLottoPurchaseAmountInput();
        lottoService.purchaseLotto(amount);
    }

}
