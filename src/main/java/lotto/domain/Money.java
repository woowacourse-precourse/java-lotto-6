package lotto.domain;

import lotto.common.consts.ErrorMessage;
import lotto.view.OutputView;

public class Money {
    private int money;
    private static final int ONE_THOUSAND_WON = 1000;
    private static final int ZERO = 0;

    public Money(int money) {
        this.money = money;
    }

    private void validate(int money) {
        if (!isPositive(money)) {
            OutputView.printError(ErrorMessage.NOT_POSITIVE_ERROR_MESSAGE);
            throw new IllegalArgumentException(ErrorMessage.NOT_POSITIVE_ERROR_MESSAGE);
        }
        if (!isDivideUp(money)) {
            OutputView.printError(ErrorMessage.NOT_DIVIDE_ZERO_ERROR_MESSAGE);
            throw new IllegalArgumentException(ErrorMessage.NOT_DIVIDE_ZERO_ERROR_MESSAGE);
        }
    }

    private boolean isPositive(int money) {
        return money > 0;
    }

    private boolean isDivideUp(int money) {
        return money % ONE_THOUSAND_WON == ZERO;
    }

    public int getDivideValue() {
        return money / ONE_THOUSAND_WON;
    }


}
