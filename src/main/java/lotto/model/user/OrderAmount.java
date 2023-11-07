package lotto.model.user;

import static lotto.model.validator.InputValidator.checkNumericInput;
import static lotto.model.validator.InputValidator.numberMustBeMultipleOf1000;

public class OrderAmount {
    private int money;

    public OrderAmount(String order) {
        checkNumericInput(order);
        numberMustBeMultipleOf1000(order);
        this.money = Integer.parseInt(order);
    }

    public int amountOfLotto() {
        return money/1000;
    }

    public double calculateProfit(LottoResults results) {
        return Double.parseDouble(String.format("%1f", results.earning() / money * 100));
    }
}
