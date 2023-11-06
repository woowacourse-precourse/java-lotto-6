package lotto.domain;

import lotto.domain.constants.LottoRule;
import lotto.message.ErrorMessage;

public class Amount {
    private final int amount;

    public Amount(int amount) {
        validate(amount);
        this.amount = amount;
    }

    public void validate(final int amount) {
        validateAmountEnough(amount);
    }

    public void validateAmountEnough(final int amount) {
        if (amount < LottoRule.PRICE.getValue()) {
            throw new IllegalArgumentException(
                    String.format(ErrorMessage.PURCHASE_AMOUNT_IS_NOT_ENOUGH.getValue(),
                            LottoRule.PRICE.getValue())
            );
        }
    }
}
