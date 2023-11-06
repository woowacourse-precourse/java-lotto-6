package Exception;

public class WinningNumberFormatException extends IllegalArgumentException {
    private static final String ERROR = "[ERROR] 당첨번호는 쉼표로 구분된 6개의 숫자여야 합니다. ex) 1,2,3,4,5,6";

    public WinningNumberFormatException() {
        super(ERROR);
    }
}
