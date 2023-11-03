package lotto.controller;

import lotto.model.Money;
import lotto.view.Input;

public class LottoController {
    public void start() {
        Money money = getMoney();
    }

    private Money getMoney() {
        return new Money(Input.inputMoney());
    }
}
