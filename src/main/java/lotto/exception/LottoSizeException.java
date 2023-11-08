package lotto.exception;

public class LottoSizeException extends IllegalArgumentException{
    private static final String ERROR_MESSAGE = "[ERROR] 6개의 서로 다른 숫자로 이루어져야 합니다.";

    public LottoSizeException() {
        super(ERROR_MESSAGE);
        System.out.println(ERROR_MESSAGE);
    }
}
