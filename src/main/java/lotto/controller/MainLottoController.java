package lotto.controller;

import lotto.view.Input;

public class MainLottoController {

    public void startLotto(){
        inPutMoney();
    }

    public void inPutMoney(){
        Input input = new Input();
        boolean vaildated = false;
        while (!vaildated){
            vaildated = input.getPurchaseAmount();
        }

    }
}
