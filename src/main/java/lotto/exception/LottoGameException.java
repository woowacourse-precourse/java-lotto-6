package lotto.exception;

public class LottoGameException extends IllegalArgumentException {
    
    private LottoGameException(ExceptionMessage exceptionMessage) {
        super(exceptionMessage.getMessage());
    }
    
    private LottoGameException(ExceptionMessage exceptionMessage, Exception exception) {
        super(exceptionMessage.getMessage(), exception);
    }
    
    public static LottoGameException of(ExceptionMessage exceptionMessage, Exception exception) {
        return new LottoGameException(exceptionMessage, exception);
    }
    
    public static LottoGameException from(ExceptionMessage exceptionMessage) {
        return new LottoGameException(exceptionMessage);
    }
}
