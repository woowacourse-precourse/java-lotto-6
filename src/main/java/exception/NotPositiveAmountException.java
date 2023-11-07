package exception;

public class NotPositiveAmountException extends NotPositiveValueException {
    public NotPositiveAmountException() {
        super("금액");
    }
}
