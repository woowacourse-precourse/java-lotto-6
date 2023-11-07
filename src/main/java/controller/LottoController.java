package controller;

import model.LottoNumber;
import model.LottoService;

public class LottoController {

    LottoService lottoService = new LottoService();
    public LottoNumber winningNumber = new LottoNumber();

    public LottoController(){
        startLotto();
    }

    public void startLotto(){
        lottoService.buyLotto();
    }

}
