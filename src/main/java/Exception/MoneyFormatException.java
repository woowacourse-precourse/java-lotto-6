package Exception;

public class MoneyFormatException extends IllegalStateException {
    private static final String ERROR = "[ERROR] 로또 구입은 1,000원 단위로 이루어집니다.";

    public MoneyFormatException() {
        super(ERROR);
    }
}
