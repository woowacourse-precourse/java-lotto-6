package lotto.controller;

import lotto.service.LottoService;

public class LottoController {

    private final LottoService lottoService = new LottoService();

    public void run() {
        setLottoCount();
        setUserLotto();
        getUserLotto();
        setWinningLotto();
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

    public void setWinningLotto() {
        lottoService.setWinningLotto();
    }
}
