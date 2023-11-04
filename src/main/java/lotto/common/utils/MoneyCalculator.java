package lotto.common.utils;

import lotto.common.consts.ErrorMessage;
import lotto.view.OutputView;

public class MoneyCalculator {

    private static final int ONE_THOUSAND_WON = 1000;
    private static final int ZERO = 0;

    public static int calculateBuy(int money) {
        if (money % ONE_THOUSAND_WON != ZERO) {
            OutputView.printError(ErrorMessage.NOT_DIVIDE_ZERO_ERROR_MESSAGE);
            throw new IllegalArgumentException();
        }
        return money / ONE_THOUSAND_WON;
    }

}
