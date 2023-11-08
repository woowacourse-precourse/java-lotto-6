package lotto;

public class ExceptionClass extends IllegalArgumentException{
    lotto.message message;

    public ExceptionClass(lotto.message exceptionMessage) {
        message = exceptionMessage;
    }
}
