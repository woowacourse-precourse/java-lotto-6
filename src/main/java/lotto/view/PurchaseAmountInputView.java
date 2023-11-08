package lotto.view;

import static lotto.view.constant.ViewConstant.InputViewConstant.InputErrorMessage.NOT_CONTAINS_ONLY_NUMBER;
import static lotto.view.constant.ViewConstant.InputViewConstant.InputErrorMessage.NOT_EXIST_INPUT_ERROR;
import static lotto.view.constant.ViewConstant.InputViewConstant.InputErrorMessage.NOT_THOUSAND_UNIT;
import static lotto.view.constant.ViewConstant.InputViewConstant.InputErrorMessage.UNDER_THOUSAND_AMOUNT;
import static lotto.view.constant.ViewConstant.InputViewConstant.LOTTO_PRICE;
import static lotto.view.constant.ViewConstant.InputViewConstant.ZERO;

import java.util.function.Supplier;

public class PurchaseAmountInputView implements LottoInputViewable, Supplier<Long> {
    @Override
    public Long get() {
        return Long.valueOf(receiveInput());
    }

    @Override
    public void validate(final String input) {
        validateAmountFormat(input);
        validateAmount(Long.parseLong(input));
    }

    private void validateAmountFormat(final String stringAmount) {
        if (stringAmount.isBlank()) {
            throw new IllegalArgumentException(NOT_EXIST_INPUT_ERROR.getErrorMessage());
        }
        if (isNotContainsOnlyNumber(stringAmount)) {
            throw new IllegalArgumentException(NOT_CONTAINS_ONLY_NUMBER.getErrorMessage());
        }
    }

    private void validateAmount(final long longAmount) {
        if (longAmount < LOTTO_PRICE) {
            throw new IllegalArgumentException(UNDER_THOUSAND_AMOUNT.getErrorMessage());
        }
        if (longAmount % LOTTO_PRICE != ZERO) {
            throw new IllegalArgumentException(NOT_THOUSAND_UNIT.getErrorMessage());
        }
    }
}
