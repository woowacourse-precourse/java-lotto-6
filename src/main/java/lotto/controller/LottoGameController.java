package lotto.controller;

import lotto.domain.money.Money;
import lotto.service.LottoGameService;

public class LottoGameController {
    private final LottoGameService lottoGameService;

    public LottoGameController(LottoGameService lottoGameService) {
        this.lottoGameService = lottoGameService;
    }

    public void play() {
        Money money = lottoGameService.purchaseAmount();


    }
}
