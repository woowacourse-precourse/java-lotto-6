package lotto.controller;

import lotto.model.service.LottoService;

public class LottoController {
    private final LottoService lottoService;
    public LottoController(LottoService lottoService){
        this.lottoService = lottoService;
    }
    public void start(){
        lottoService.startLotto();
        lottoService.drawProcess();
        lottoService.calculateProfit();
        lottoService.resultOutput();
    }
}
