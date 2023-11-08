package exception;

public class Exception {

    public static void raiseInvalidMoneyRangeException() {
        throw new IllegalArgumentException(ExceptionMessage.INVALID_MONEY_RANGE_MESSAGE.getMessage());
    }

    public static void raiseInvalidMoneyArgumentException() {
        throw new IllegalArgumentException(ExceptionMessage.INVALID_MONEY_ARGUMENT_MESSAGE.getMessage());
    }

    public static void raiseMoneyNotDevidedByThousandException() {
        throw new IllegalArgumentException(ExceptionMessage.MONEY_NOT_BEING_DEVIDED_BY_THOUSAND_MESSAGE.getMessage());
    }

    public static void raiseInvalidWinningNumberArgumentException() {
        throw new IllegalArgumentException(ExceptionMessage.INVALID_WINNING_NUMBER_ARGUMENT_MESSAGE.getMessage());
    }

    public static void raiseInvalidWinningNumberRangeException() {
        throw new IllegalArgumentException(ExceptionMessage.INVALID_WINNING_NUMBER_RANGE_MESSAGE.getMessage());
    }

    public static void raiseInvalidWinningNumberInputFormatException() {
        throw new IllegalArgumentException(ExceptionMessage.INVALID_WINNING_NUMBER_INPUT_FORMAT_MESSAGE.getMessage());
    }

    public static void raiseInvalidWinningNumberDuplicationException() {
        throw new IllegalArgumentException(ExceptionMessage.INVALID_WINNING_NUMBER_DUPLICATION_MESSAGE.getMessage());
    }

    public static void raiseInvalidBonusNumberArgumentException() {
        throw new IllegalArgumentException(ExceptionMessage.INVALID_BONUS_NUMBER_ARGUMENT_MESSAGE.getMessage());
    }

    public static void raiseInvalidBonusNumberRangeMessage() {
        throw new IllegalArgumentException((ExceptionMessage.INVALID_BONUS_NUMBER_RANGE_MESSAGE.getMessage()));
    }

    public static void raiseInvalidInputException() {
        throw new IllegalArgumentException(ExceptionMessage.INVALID_INPUT_MESSAGE.getMessage());
    }
}
