package lotto.controller;

import lotto.service.LottoService;

public class LottoGame {
    private final LottoService lottoService = new LottoService();
    private static final int DIVIDED_AMOUNT = 1000;

    public void start() {
        lottoService.createLottoCount();
    }

}
