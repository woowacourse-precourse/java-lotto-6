package lotto.exception;

import static lotto.enums.AmountStatus.MAX_VALUE;
import static lotto.enums.AmountStatus.MIN_VALUE;

public class IllegalAmountException extends LottoApplicationException {
    private static final String DEFAULT_MESSAGE =
            "최소단위는 " + MIN_VALUE.getCurrencyForm() + "원이며 " + MAX_VALUE.getCurrencyForm() + "원 까지 입금 가능합니다.";

    public IllegalAmountException() {
        super(DEFAULT_MESSAGE);
    }
}
