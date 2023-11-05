package lotto.controller;

import lotto.model.Money;
import lotto.view.InputView;

public class LottoController {

    public void start() {
        Money money = getMoney();
    }

    private Money getMoney() {
        int money = InputView.inputBuyLottoMoney();
        return new Money(money);
    }
}
