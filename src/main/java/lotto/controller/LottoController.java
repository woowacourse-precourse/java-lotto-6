package lotto.controller;

import java.util.List;
import lotto.domain.Lotto;
import lotto.service.LottoService;
import lotto.view.InputView;

public class LottoController {

    LottoService lottoService = new LottoService();
    InputView inputView = new InputView();

    public void playLotto() {

        int purchaseAmount = inputView.readPurchaseAmount();
        List<Lotto> lottoTickets = lottoService.purchaseLottoTickets(purchaseAmount);

    }

}
