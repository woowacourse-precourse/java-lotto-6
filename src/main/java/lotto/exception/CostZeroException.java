package lotto.exception;

public class CostZeroException extends IllegalArgumentException {
    public final static CostZeroException costZeroException = new CostZeroException();

    private CostZeroException() {
        super("[ERROR] 금액은 0이 될 수 없습니다.");
    }

    @Override
    public synchronized Throwable fillInStackTrace() {
        return this;
    }
}
