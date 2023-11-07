package Exception;

public class BonusNumberNotNumberException extends IllegalArgumentException {
    private static final String ERROR = "[ERROR] 보너스 번호는 숫자여야합니다.";

    public BonusNumberNotNumberException() {
        super(ERROR);
    }
}
