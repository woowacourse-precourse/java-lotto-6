package lotto.controller;

import lotto.model.Money;
import lotto.model.Store;
import lotto.model.User;
import lotto.view.InputView;

public class InputController {
    public static User makeUser() {
        Money money = makeMoney();
        Store store = makeStore(money);
        return new User(store.getLottoCount(), store.getLottoTickets());
    }

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
