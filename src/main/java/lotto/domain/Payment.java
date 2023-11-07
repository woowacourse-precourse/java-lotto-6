package lotto.domain;

import static lotto.ErrorMessage.PAYMENT_LESS_THAN_1000;
import static lotto.ErrorMessage.PAYMENT_MORE_THAN_100000;
import static lotto.ErrorMessage.PAYMENT_NOT_DIVISIBLE_BY_1000;
import static lotto.LottoConstance.MAX_PAYMENT;
import static lotto.LottoConstance.MIN_PAYMENT;

public class Payment {

    private final int money;

    public Payment(int money) {
        validate(money);
        this.money = money;
    }

    public int numberLottoTicketsCanBuy() {
        return money / MIN_PAYMENT.get();
    }

    public int get() {
        return money;
    }

    private void validate(int money) {
        if (isLessThan1000(money)) {
            throwException(PAYMENT_LESS_THAN_1000.get());
        } else if (isMoreThan100000(money)) {
            throwException(PAYMENT_MORE_THAN_100000.get());
        } else if (canNotDivision1000(money)) {
            throwException(PAYMENT_NOT_DIVISIBLE_BY_1000.get());
        }
    }

    private boolean isLessThan1000(int money) {
        return money < MIN_PAYMENT.get();
    }

    private boolean isMoreThan100000(int money) {
        return money > MAX_PAYMENT.get();
    }

    private boolean canNotDivision1000(int money) {
        return money % MIN_PAYMENT.get() != 0;
    }

    private void throwException(String errorMessage) {
        throw new IllegalArgumentException(errorMessage);
    }
}
