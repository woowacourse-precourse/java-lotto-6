package exception;

public class InvalidMoneyFormatException extends IllegalArgumentException {
    private static final String ERROR_MESSAGE = "[ERROR] 입력 값이 정수 형태가 아닙니다!";

    public InvalidMoneyFormatException() {
        super(ERROR_MESSAGE);
    }
}
