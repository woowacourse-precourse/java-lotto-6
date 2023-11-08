package lotto.controller;

import lotto.service.LottoService;

public class LottoMachine {
    private final LottoService lottoService;

    public LottoMachine() {
        this.lottoService = new LottoService();
    }

    public void lotto() {
    }
}
