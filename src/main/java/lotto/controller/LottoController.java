package lotto.controller;

import lotto.Lotto;
import lotto.service.LottoService;
import lotto.view.LottoInputView;

import java.util.List;

public class LottoController {

    private final LottoInputView lottoInputView = new LottoInputView();
    private final LottoService lottoService = new LottoService();

    public void run() {
        buyLottoTicketProcess();
    }

    private void buyLottoTicketProcess() {
        Long amount = lottoInputView.getLottoPurchaseAmountInput();
        List<Lotto> lottos = lottoService.purchaseLotto(amount);

    }

}
