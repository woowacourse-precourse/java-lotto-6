package lotto.controller;

import lotto.view.InputView;

public class LottoController {

    public void run(){
        try{
            start();
        }
        catch(IllegalArgumentException e){
            e.printStackTrace();
        }
    }

    public void start(){
        String playCount= InputView.inputPlayerPrice();

    }
}
