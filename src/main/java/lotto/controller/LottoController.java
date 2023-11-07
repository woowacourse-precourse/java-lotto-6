package lotto.controller;

import java.util.List;
import lotto.view.InputView;
import lotto.domain.PlayerLottoAmount;

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
        new PlayerLottoAmount(playCount);

        List<Integer> list = InputView.inputLottoNumber();
    }
}
