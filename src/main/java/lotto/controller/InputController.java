package lotto.controller;

import lotto.model.Money;
import lotto.model.Store;
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

    private static Store makeStore(Money money) {
        try {
            Store store = new Store(money);
            return store;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return makeStore(money);
        }
    }
}
