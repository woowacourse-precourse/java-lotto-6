package lotto.controller;

import lotto.service.LottoService;

public class LottoMachine {
    private LottoService lottoService = new LottoService();

    public LottoMachine() {
        this.lottoService = new LottoService();
    }

    public void lotto() {
    }
}
