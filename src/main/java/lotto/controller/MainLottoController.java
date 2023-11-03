package lotto.controller;

import lotto.domain.Money;
import lotto.view.Input;

public class MainLottoController {
    Input input = new Input();
    Money money;

    public void startLotto(){
        inPutMoney();
    }

    public Money inPutMoney(){
        try{
            return new Money(input.getPurchaseAmount());
        }catch (IllegalArgumentException e){
            System.out.println("잘못되었음");
        }   return inPutMoney();
    }
}
