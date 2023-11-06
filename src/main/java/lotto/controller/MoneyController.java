package lotto.controller;

import lotto.domain.Money;
import lotto.view.InputView;

public class MoneyController {

    public Money inputMoney() {
        return new Money(InputView.inputMoney());
    }
}
