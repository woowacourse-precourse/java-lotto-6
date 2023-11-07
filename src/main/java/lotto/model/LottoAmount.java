package lotto.model;

import static lotto.validation.validation.isInvalidNumber;
import static lotto.validation.validation.isNotDivisible;
import static lotto.validation.validation.isZeroInput;


public class LottoAmount {
    private static final int THOUSAND = 1000;
    private final int amount;

    public LottoAmount(String amount) {
        int number = isInvalidNumber(amount);
        isZeroInput(number);
        isNotDivisible(number);
        this.amount = number;
    }


    public int getlottoTicketCount() {
        return (amount / THOUSAND);
    }
}
