package lotto.validator;

import static lotto.constants.ExceptionMessage.*;
import static lotto.constants.LottoSetting.PRICE_MAX_LIMIT;
import static lotto.constants.LottoSetting.PRICE_PER_TICKET;

public class LottoPayAmountValidator implements Validator {

    @Override
    public void validate(String input) {
        long amount = parseAmount(input);
        validateAmountUnit(amount);
        validateAmountRange(amount);
    }

    private long parseAmount(String input) {
        try {
            return Long.parseLong(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NOT_NUMERIC_ERROR.message());
        }
    }

    private void validateAmountUnit(long amount) {
        if (amount % PRICE_PER_TICKET.value() != 0) {
            throw new IllegalArgumentException(AMOUNT_NOT_THOUSAND_UNIT_ERROR.message());
        }
    }

    private void validateAmountRange(long amount) {
        if (amount > PRICE_MAX_LIMIT.value()) {
            throw new IllegalArgumentException(AMOUNT_MAX_LIMIT_ERROR.message());
        }
    }
}
