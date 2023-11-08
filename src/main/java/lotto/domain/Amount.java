package lotto.domain;

import lotto.constant.ExceptionType;
import lotto.constant.LottoConstant;
import lotto.util.TypeConverter;

public class Amount {
    private final int amount;

    public Amount(String amount) {
        try {
            this.amount = TypeConverter.convertToInteger(amount);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ExceptionType.AMOUNT_NOT_INTEGER.getMessage());
        }

        validate(this.amount);
    }

    public int getAmount() {
        return amount;
    }

    private void validate(int amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException(ExceptionType.AMOUNT_NOT_POSITIVE.getMessage());
        } else if (amount % LottoConstant.PRICE.getNumber() != 0) {
            throw new IllegalArgumentException(ExceptionType.AMOUNT_NOT_DIVIDED_BY_PRICE.getMessage());
        }
    }
}
