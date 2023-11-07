package Exception;

public class MoneyNotNumberException extends IllegalArgumentException {
    private static final String ERROR = "[ERROR] 로또 구입 금액은 숫자로만 이루어져야 합니다.";

    public MoneyNotNumberException() {
        super(ERROR);
    }
}
