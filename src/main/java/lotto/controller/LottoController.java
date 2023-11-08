package lotto.controller;

import lotto.service.LottoService;
import lotto.view.LottoView;

public class LottoController {
    private final LottoView consoleLottoView;
    private final LottoService lottoService;

    public LottoController(LottoView consoleLottoView, LottoService lottoService) {
        this.consoleLottoView = consoleLottoView;
        this.lottoService = lottoService;
    }

    public void startGame() {
        String purchaseAmount = consoleLottoView.getPurchaseAmount();
    }
}
