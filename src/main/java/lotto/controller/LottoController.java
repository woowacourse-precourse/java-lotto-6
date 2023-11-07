package lotto.controller;

import lotto.domain.LottoCalculate;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    public void run() {
        try{
            start();
        } catch (IllegalArgumentException e){
            System.out.println("[ERROR] "+e.getMessage());
        }
    }
    public void start(){
        int amount = getAmount();

    }

    public int getAmount(){
        OutputView.requestMoney();
        String money = InputView.getInputNumber();
        return LottoCalculate.calcAmount(Integer.parseInt(money));
    }
}
