package lotto.controller;

import lotto.service.LottoService;

public class LottoController {
    private final LottoService lottoService;

    public LottoController(LottoService lottoService){
        this.lottoService = lottoService;
    }

    public void run(){
        lottoService.decideHowMuchToBuy();
        lottoService.buyLotto();
        lottoService.announceWinner();
        lottoService.matchLotto();
        lottoService.showStatistics();
    }
}
