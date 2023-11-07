package lotto.controller;

import lotto.domain.Money;
import lotto.view.InputView;

public class LottoController {
    public void play() {

    }

    public void start() {
        int inputMoney = InputView.inputMoney();
        Money money = new Money(inputMoney);
        int trial = money.trial();
    }
}
