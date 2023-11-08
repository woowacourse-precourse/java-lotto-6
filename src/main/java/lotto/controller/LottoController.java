package lotto.controller;

import lotto.service.LottoService;

public class LottoController {

    private final LottoService lottoService = new LottoService();

    public void run() {
        setLottoCount();
        setUserLotto();
        getUserLotto();
    }

    public void setLottoCount() {
        lottoService.setLottoCount();
    }

    public void setUserLotto() {
        lottoService.setUserLotto();
    }

    public void getUserLotto() {
        lottoService.getUserLotto();
    }
}
