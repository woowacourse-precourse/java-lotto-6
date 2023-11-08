package lotto.view.exception;

import lotto.view.message.exception.UserMoneyInputExceptionMessage;

public class UserMoneyInputException extends IllegalArgumentException {
    private UserMoneyInputException(final UserMoneyInputExceptionMessage userMoneyInputExceptionMessage) {
        super(userMoneyInputExceptionMessage.getMessage());
    }

    public static UserMoneyInputException of(final UserMoneyInputExceptionMessage userMoneyInputExceptionMessage) {
        return new UserMoneyInputException(userMoneyInputExceptionMessage);
    }
}
