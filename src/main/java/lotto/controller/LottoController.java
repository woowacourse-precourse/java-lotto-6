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
        try{
            lottoService.setLottoCount();
        } catch(IllegalArgumentException e) {
            setLottoCount();
        }
    }

    public void setUserLotto() {
        try{
            lottoService.setUserLotto();
        } catch(IllegalArgumentException e) {
            setUserLotto();
        }
    }

    public void getUserLotto() {
        lottoService.getUserLotto();
    }

    public void setWinningLotto() {
        try{
            lottoService.setWinningLotto();
        } catch(IllegalArgumentException e) {
            setWinningLotto();
        }
    }

    public void setBonusNum() {
        try{
            lottoService.setBonusNum();
        } catch(IllegalArgumentException e) {
            setBonusNum();
        }
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
