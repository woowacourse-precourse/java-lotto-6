package lotto.controller;

import lotto.domain.User;
import lotto.service.LottoService;
import lotto.views.InputView;

public class LottoController {
    private final LottoService lottoService;

    public LottoController(LottoService lottoService) {
        this.lottoService = lottoService;
    }

    public void run(){
        InputView inputView = new InputView();
        long purchaseAmount = inputView.getPurchaseAmount();
        User user = lottoService.buyLotto(purchaseAmount);
    }
}
