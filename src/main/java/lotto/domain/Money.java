package lotto.domain;

import lotto.common.consts.ErrorMessage;
import lotto.view.OutputView;

public class Money {
    private long money;
    private static final int ONE_THOUSAND_WON = 1000;
    private static final int ZERO = 0;

    public Money(long money) {
        this.money = money;
    }

    private void validate(long money) {
        if (!isPositive(money)) {
            OutputView.printError(ErrorMessage.NOT_POSITIVE_ERROR_MESSAGE);
            throw new IllegalArgumentException(ErrorMessage.NOT_POSITIVE_ERROR_MESSAGE);
        }
        if (!isDivideUp(money)) {
            OutputView.printError(ErrorMessage.NOT_DIVIDE_ZERO_ERROR_MESSAGE);
            throw new IllegalArgumentException(ErrorMessage.NOT_DIVIDE_ZERO_ERROR_MESSAGE);
        }
    }

    private boolean isPositive(long money) {
        return money > 0L;
    }

    private boolean isDivideUp(long money) {
        return money % ONE_THOUSAND_WON == ZERO;
    }

    public long getDivideValue() {
        return money / ONE_THOUSAND_WON;
    }


}
