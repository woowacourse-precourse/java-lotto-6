package lotto.controller;

import lotto.service.LottoService;

public class LottoController {
    private final LottoService service;

    public LottoController(LottoService service) {
        this.service = service;
    }

    public void run() {
        setupBuyLotto();
        setupWinningNumbers();
    }

    private void setupBuyLotto() {
        service.setupBuyLotto();
    }

    private void setupWinningNumbers() {
        service.setupWinningNumbers();
    }
}
