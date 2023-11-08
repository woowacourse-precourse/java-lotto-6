package lotto.exception;

import lotto.config.LottoGameRule;

public class InvalidPurchaseAmountException extends LottoGameException {

    private static final String MESSAGE =
            String.format("구입 금액은 %d원 단위로 입력 해야 합니다.", LottoGameRule.PURCHASE_AMOUNT_UNIT.value());

    public InvalidPurchaseAmountException() {
        super(MESSAGE);
    }
}
