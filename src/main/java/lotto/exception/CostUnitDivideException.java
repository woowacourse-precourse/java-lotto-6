package lotto.exception;

public class CostUnitDivideException extends IllegalArgumentException {
    public final static CostUnitDivideException costUnitDivideException = new CostUnitDivideException();

    private CostUnitDivideException() {
        super("[ERROR] 입력은 1000원단위이여야 합니다.");
    }

    @Override
    public synchronized Throwable fillInStackTrace() {
        return this;
    }
}
