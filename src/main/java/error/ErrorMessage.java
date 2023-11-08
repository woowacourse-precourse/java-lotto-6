package error;


import constant.GameValues;
import lotto.ConsoleIO;

public enum ErrorMessage {

    //input error
    INVALID_MONEY_UNIT(
            ErrorType.USER_INPUT
            , "금액은 %s원단위로 입력 해야합니다."
            , GameValues.MONEY_UNIT.getValue()
    ),
    INVALID_NUM_TYPE(
            ErrorType.USER_INPUT
            , "숫자를 입력해주세요"
    ),
    INVALID_MONEY_RANGE(
            ErrorType.USER_INPUT
            , "입력할 수 있는 금액은 %s원이상 %s원이하입니다."
            , GameValues.MIN_MONEY.getValue()
            , GameValues.MAX_MONEY.getValue()
    ),
    INVALID_LOTTO_NUM_RANGE(
            ErrorType.USER_INPUT
            , "%s부터 %s사이의 숫자여야 합니다."
            , GameValues.MIN_LOTTO_NUM
            , GameValues.MAX_LOTTO_NUM
    ),
    INVALID_WINNING_LOTTO_NUM_VALUE(
            ErrorType.USER_INPUT
            , "당첨 번호는 %s개이며, ','로 구분되어야 합니다."
            , GameValues.LOTTO_WINNING_NUM_SIZE
    ),
    DUPLICATE_LOTTO_NUM(
            ErrorType.USER_INPUT
            , "로또 번호는 서로 다른 수여야 합니다."
    );


    private final String message;
    private final ErrorType errorType;


    ErrorMessage(ErrorType errorType, String message, Object... args) {
        this.errorType = errorType;
        this.message = String.format(message, args);
    }

    ErrorMessage(ErrorType errorType, String message) {
        this.errorType = errorType;
        this.message = message;
    }

    public void errorHandle() {
        ConsoleIO.printMessage("[ERROR] " + message);
        throw getThrowableType();
    }


    private RuntimeException getThrowableType() {
        return errorType.getException();
    }

    @Override
    public String toString() {
        return this.message;
    }
}
