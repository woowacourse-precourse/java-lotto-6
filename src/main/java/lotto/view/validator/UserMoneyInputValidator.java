package lotto.view.validator;

import lotto.constant.LottoConstant;
import lotto.view.constant.InputConstant;
import lotto.view.exception.UserMoneyInputException;
import lotto.view.message.exception.UserMoneyInputExceptionMessage;

public class UserMoneyInputValidator {
    public void validate(final String userMoney) {
        isNotEmpty(userMoney);
        isNumeric(userMoney);
        isDivisibleWithLottoPrice(userMoney);
    }

    private void isNotEmpty(final String userMoney) {
        if (userMoney.isEmpty()) {
            throw UserMoneyInputException.of(UserMoneyInputExceptionMessage.INPUT_IS_EMPTY);
        }
    }

    private void isNumeric(final String userMoney) {
        try {
            Long.parseLong(userMoney);
        } catch (NumberFormatException e) {
            throw UserMoneyInputException.of(UserMoneyInputExceptionMessage.USER_MONEY_IS_NOT_NUMERIC_TYPE);
        }
    }

    private void isDivisibleWithLottoPrice(final String userMoney) {
        if (!divisibleWithLottoPrice(userMoney)) {
            throw UserMoneyInputException.of(
                    UserMoneyInputExceptionMessage.USER_MONEY_IS_NOT_DIVISIBLE_WITH_LOTTO_PRICE);
        }
    }

    private boolean divisibleWithLottoPrice(final String userMoney) {
        return Long.parseLong(userMoney) % LottoConstant.LOTTO_PRICE.getValue() == InputConstant.ZERO;
    }
}