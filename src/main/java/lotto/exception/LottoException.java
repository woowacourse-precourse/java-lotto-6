package lotto.exception;

public class LottoException extends IllegalArgumentException {
    private LottoException(Message message) {
        super(message.getMessage());
    }

    public static LottoException of(Message message) {
        System.out.println(message.getMessage());
        return new LottoException(message);
    }
}
