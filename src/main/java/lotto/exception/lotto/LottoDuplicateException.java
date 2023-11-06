package lotto.exception.lotto;

public class LottoDuplicateException extends IllegalArgumentException{
    private static final String ERROR_MSG = "[ERROR] 로또 번호는 중복되면 안됩니다.";

    public LottoDuplicateException(){
        super(ERROR_MSG);
    }
}
