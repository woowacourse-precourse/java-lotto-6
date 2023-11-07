package lotto.exception.lotto;

public class IllegalNumberCountException extends IllegalArgumentException {
    private static final String ERROR_MESSAGE = "[ERROR] 로또 번호는 6개여야 합니다.";
    
    public IllegalNumberCountException() {
        super(ERROR_MESSAGE);
    }
}
