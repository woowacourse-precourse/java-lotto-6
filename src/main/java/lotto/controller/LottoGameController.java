package lotto.controller;

import lotto.service.LottoGameService;

public class LottoGameController {

    private final LottoGameService lottoGameService = new LottoGameService();

    public void run() {
        lottoGameService.play();
    }
}
