package exception;

public class Exception {

    void raiseInvalidMoneyRangeException() {
        throw new IllegalArgumentException(ExceptionMessage.INVALID_MONEY_RANGE_MESSAGE.getMessage());
    }

    void raiseInvalidMoneyArgumentException() {
        throw new IllegalArgumentException(ExceptionMessage.INVALID_MONEY_ARGUMENT_MESSAGE.getMessage());
    }

    void raiseMoneyNotDevidedByThousandException() {
        throw new IllegalArgumentException(ExceptionMessage.MONEY_NOT_BEING_DEVIDED_BY_THOUSAND_MESSAGE.getMessage());
    }

    void raiseInvalidWinningNumberArgumentException() {
        throw new IllegalArgumentException(ExceptionMessage.INVALID_WINNING_NUMBER_ARGUMENT_MESSAGE.getMessage());
    }

    void raiseInvalidWinningNumberRangeException() {
        throw new IllegalArgumentException(ExceptionMessage.INVALID_WINNING_NUMBER_RANGE_MESSAGE.getMessage());
    }

    void raiseInvalidWinningNumberInputFormatException() {
        throw new IllegalArgumentException(ExceptionMessage.INVALID_WINNING_NUMBER_INPUT_FORMAT_MESSAGE.getMessage());
    }

    void raiseInvalidWinningNumberDuplicationException() {
        throw new IllegalArgumentException(ExceptionMessage.INVALID_WINNING_NUMBER_DUPLICATION_MESSAGE.getMessage());
    }

    void raiseInvalidBonusNumberArgumentException() {
        throw new IllegalArgumentException(ExceptionMessage.INVALID_BONUS_NUMBER_ARGUMENT_MESSAGE.getMessage());
    }

    void raiseInvalidBonusNumberRangeMessage() {
        throw new IllegalArgumentException((ExceptionMessage.INVALID_BONUS_NUMBER_RANGE_MESSAGE.getMessage()));
    }
}
