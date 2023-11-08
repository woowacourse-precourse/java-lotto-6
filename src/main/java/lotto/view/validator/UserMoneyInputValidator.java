package lotto.view.validator;

import lotto.constant.LottoConstant;
import lotto.view.constant.InputConstant;
import lotto.view.exception.LottoInputException;
import lotto.view.message.LottoInputExceptionMessage;

public class UserMoneyInputValidator {
    public void validate(final String userMoney) {
        isNotEmpty(userMoney);
        isNumeric(userMoney);
        isDivisibleWithLottoPrice(userMoney);
    }

    private void isNotEmpty(final String userMoney) {
        if (userMoney.isEmpty()) {
            throw LottoInputException.of(LottoInputExceptionMessage.INPUT_IS_EMPTY);
        }
    }

    private void isNumeric(final String userMoney) {
        try {
            Long.parseLong(userMoney);
        } catch (NumberFormatException e) {
            throw LottoInputException.of(LottoInputExceptionMessage.USER_MONEY_IS_NOT_NUMERIC_TYPE);
        }
    }

    private void isDivisibleWithLottoPrice(final String userMoney) {
        if (!divisibleWithLottoPrice(userMoney)) {
            throw LottoInputException.of(LottoInputExceptionMessage.USER_MONEY_IS_NOT_DIVISIBLE_WITH_LOTTO_PRICE);
        }
    }

    private boolean divisibleWithLottoPrice(final String userMoney) {
        return Long.parseLong(userMoney) % LottoConstant.LOTTO_PRICE.getValue() == InputConstant.ZERO;
    }
}