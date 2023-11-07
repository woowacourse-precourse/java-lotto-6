package lotto.controller;

import lotto.service.LottoService;

public class LottoController {

    private final LottoService lottoService = new LottoService();

    public void run() {
        setLottoCount();
    }

    public void setLottoCount(){
        lottoService.setLottoCount();
    }
}
