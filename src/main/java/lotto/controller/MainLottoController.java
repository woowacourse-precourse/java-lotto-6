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
        return new Money(input.getPurchaseAmount());
    }
}
