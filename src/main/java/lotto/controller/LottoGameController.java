package lotto.controller;

import lotto.application.LottoService;
import lotto.domain.Money;
import lotto.view.InputView;

public class LottoGameController {

    private final LottoService lottoService;

    public LottoGameController(LottoService lottoService) {
        this.lottoService = lottoService;
    }

    public void lottoGame() {
        int input = InputView.readPayMoney();
        lottoService.gameStart(Money.of(input));
    }
}
