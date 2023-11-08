package lotto.exception;

public class LottoException extends IllegalArgumentException{
    private final LottoExceptionMessage message;

    public LottoException(LottoExceptionMessage message) {
        this.message = message;
        System.out.println(message.getMessage());
    }

    @Override
    public String getMessage() {
        return message.getMessage();
    }
}
