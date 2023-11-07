package lotto.controller;

import lotto.model.Money;
import lotto.view.InputView;

public class InputController {


    private static Money makeMoney() {
        try {
            Money money = new Money(InputView.inputMoney());
            return money;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return makeMoney();
        }
    }
}
