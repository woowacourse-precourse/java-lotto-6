package lotto.exception;

public class DataTypeRangeException extends IllegalArgumentException {
    public static final DataTypeRangeException dataTypeRangeException = new DataTypeRangeException();

    private DataTypeRangeException() {
        super("[ERROR] 입력값이 허용된 범위를 벗어났습니다.");
    }

    @Override
    public synchronized Throwable fillInStackTrace() {
        return this;
    }
}
