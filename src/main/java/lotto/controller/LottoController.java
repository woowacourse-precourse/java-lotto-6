package lotto.controller;

import lotto.domain.Money;
import lotto.view.InputView;

public class LottoController {

    private final InputView inputView = new InputView();

    public void run() {
        Money money = askMoney();
    }

    private Money askMoney() {
        return new Money(inputView.requestMoney());
    }
}
