package lotto.exception;

public class SizeException extends IllegalArgumentException {

    public static final String SIZE_ERROR_MESSAGE = "[ERROR] 로또 번호는 6개이어야 합니다.";

    public SizeException() {
        super(SIZE_ERROR_MESSAGE);
    }
}
