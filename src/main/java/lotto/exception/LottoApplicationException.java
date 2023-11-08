package lotto.exception;

public class LottoApplicationException extends RuntimeException {

    private ExceptionMessage exceptionMessage;

    public LottoApplicationException(ExceptionMessage exceptionMessage) {
        super(exceptionMessage.getMessage());
        this.exceptionMessage = exceptionMessage;
    }

    public void getErrorMessage() {
        System.out.println(this.exceptionMessage.getMessage());
    }

}
