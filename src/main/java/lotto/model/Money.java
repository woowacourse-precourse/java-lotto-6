package lotto.model;

import static lotto.util.ConstantNumbers.TICKET_PRICE;
import static lotto.util.Validator.*;

public class Money {
    private static Money instance;

    private final Integer money;

    private Money (String money) {
        validateHasSpace(money);
        validateIsInteger(money);

        this.money = Integer.parseInt(money);
        validateHasRemainingNumber(this.money);
    }

    public static Money of (String money) {
        if (instance == null) {
            instance = new Money(money);
        }
        return instance;
    }

    public Integer countTicketQuantity () {
        return money / TICKET_PRICE.getConstant();
    }
}
