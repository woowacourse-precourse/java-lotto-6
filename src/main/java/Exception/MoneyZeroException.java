package Exception;

public class MoneyZeroException extends IllegalStateException {
    private static final String ERROR = "[ERROR] 로또 구입 금액은 0보다 큰 값이어야 합니다.";

    public MoneyZeroException() {
        super(ERROR);
    }
}
