package lotto.controller;

import lotto.service.LottoService;

public class LottoGame {
    private LottoService lottoService = new LottoService();

    public LottoGame() {
        this.lottoService = new LottoService();
    }

    public void gameStart() {
    }
}
