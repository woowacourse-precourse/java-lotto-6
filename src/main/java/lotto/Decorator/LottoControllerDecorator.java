package lotto.Decorator;

import lotto.Controller.LottoController;
import lotto.Domain.Money;
import lotto.Exception.MoneyException;

public class LottoControllerDecorator extends LottoController {

    private LottoControllerDecorator() {
        super();
    }

    public static LottoControllerDecorator of() {
        return new LottoControllerDecorator();
    }

    @Override
    public Money getMoney() {
        Money money = null;
        do {
            try {
                money = super.getMoney();
            } catch (MoneyException e) {
                System.err.println(e.getMessage());
            }
        } while (money == null);

        return money;
    }
}
