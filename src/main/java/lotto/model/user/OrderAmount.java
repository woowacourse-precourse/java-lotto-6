package lotto.model.user;

import static lotto.model.constants.IntegerConstant.*;
import static lotto.validator.Validator.*;

public class OrderAmount {
    private final int money;

    public OrderAmount(String order) {
        checkNumericInput(order);
        numberMustBeMultipleOf1000(order);
        this.money = Integer.parseInt(order);
    }

    public int amountOfLotto() {
        return money/THOUSAND_DIVISOR.get();
    }

    public String calculateProfit(LottoResults results) {
        return String.format("%.1f", (results.earning() / money) * HUNDRED_DIVISOR.get());
    }
}
