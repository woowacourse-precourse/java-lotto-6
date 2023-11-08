package lotto.exception;

public class LottoGameException extends IllegalArgumentException{
    private LottoGameException(String message){
        super(message);
    }

    public static LottoGameException of(String message){
        return new LottoGameException(message);
    }
}
