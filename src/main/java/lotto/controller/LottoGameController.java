package lotto.controller;

import lotto.service.LottoService;

public class LottoGameController {

    private final LottoService lottoService;

    public LottoGameController(LottoService lottoService) {
        this.lottoService = lottoService;
    }

    public void run() {
        lottoPurchase();
        lottoGameInit();
        printLottoResults();
    }

    private void lottoPurchase() {
    }

    private void lottoGameInit() {
    }

    private void printLottoResults() {
    }
}
