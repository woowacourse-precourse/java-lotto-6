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
}
