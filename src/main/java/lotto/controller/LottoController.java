package lotto.controller;

import lotto.service.LottoService;

public class LottoController {

    private final LottoService lottoService = new LottoService();

    public void run() {
        setLottoCount();
        setUserLotto();
        getUserLotto();
        setWinningLotto();
        setBonusNum();
        getRank();
        getResult();
        getProfit();
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

    public void setBonusNum() {
        lottoService.setBonusNum();
    }

    public void getRank() {
        lottoService.getRank();
    }

    public void getResult() {
        lottoService.getResult();
    }

    public void getProfit() {
        lottoService.getProfit();
    }
}
