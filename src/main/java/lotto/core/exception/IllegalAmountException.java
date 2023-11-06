package lotto.core.exception;

import lotto.core.enums.AmountEnum;

public class IllegalAmountException extends LottoApplicationException {
    private static final String DEFAULT_MESSAGE =
            "최소단위는 " + AmountEnum.MIN_VALUE.getCurrencyForm() + "원이며 " + AmountEnum.MAX_VALUE.getCurrencyForm() + "원 까지 입니다.";

    public IllegalAmountException() {
        super(DEFAULT_MESSAGE);
    }
}
