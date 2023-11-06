package controller;

import model.MyLotto;
import model.WinningNumber;
import service.InputService;
import view.OutputView;

public class LottoController {

    InputService inputService = new InputService();
    public WinningNumber winningNumber = new WinningNumber();


    public LottoController(){
        startLotto();
    }

    public void startLotto(){
        inputService.getLottoCost();

    }

}
