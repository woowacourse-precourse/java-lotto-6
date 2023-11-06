package Exception;

public class OutOfRangeNumberException extends IllegalArgumentException {
    private static final String ERROR = "[ERROR] 로또 번호는 1 이상 45 이하의 값이어야 합니다.";

    public OutOfRangeNumberException() {
        super(ERROR);
    }
}
