package lotto.controller;

import lotto.service.LottoService;

public class LottoController {
    private final LottoService lottoService = new LottoService();

    public void run() {
        lottoService.createPlayerLotto();
        lottoService.printPlayerLotto();
        lottoService.createWinningLotto();
        lottoService.matchLotto();
        lottoService.printMatchLotto();
    }
}
