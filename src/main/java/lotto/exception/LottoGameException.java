package lotto.exception;

public class LottoGameException extends IllegalArgumentException {
    
    private LottoGameException(final ExceptionMessage exceptionMessage) {
        super(exceptionMessage.getMessage());
    }
    
    private LottoGameException(
            final ExceptionMessage exceptionMessage, final Exception exception) {
        
        super(exceptionMessage.getMessage(), exception);
    }
    
    public static LottoGameException of(
            final ExceptionMessage exceptionMessage, final Exception exception) {
        
        return new LottoGameException(exceptionMessage, exception);
    }
    
    public static LottoGameException from(final ExceptionMessage exceptionMessage) {
        return new LottoGameException(exceptionMessage);
    }
}
