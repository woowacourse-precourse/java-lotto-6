package controller;

import model.LottoNumber;
import service.InputService;

public class LottoController {

    InputService inputService = new InputService();
    public LottoNumber winningNumber = new LottoNumber();


    public LottoController(){
        startLotto();
    }

    public void startLotto(){
        inputService.getLottoCost();
        inputService.createLottoNumber();
    }

}
