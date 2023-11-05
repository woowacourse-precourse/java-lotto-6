package lotto.model;

import static lotto.util.ConstantNumbers.TICKET_PRICE;
import static lotto.util.Validator.*;

public class Money {

    private final Integer money;

    private Money (String money) {
        validateHasSpace(money);
        validateIsInteger(money);

        this.money = Integer.parseInt(money);
        validateHasRemainingNumber(this.money);
    }

    public static Money of (String money) {
        return new Money(money);
    }

    public Integer countTicketQuantity () {
        return money / TICKET_PRICE.getConstant();
    }

    public Double calculateTotalReturn (Integer total) {
        return (double) total / money * 100.0;
    }
}
