package lotto.model;

import static lotto.validation.Validation.isInvalidNumber;
import static lotto.validation.Validation.isNotDivisible;
import static lotto.validation.Validation.isZeroInput;


public class LottoAmount {
    private static final int THOUSAND = 1000;
    private final int amount;

    public LottoAmount(String amount) {
        int number = isInvalidNumber(amount);
        isZeroInput(number);
        isNotDivisible(number);
        this.amount = number;
    }

    public int getAmount() {
        return amount;
    }

    public int getlottoTicketCount() {
        return (amount / THOUSAND);
    }
}
