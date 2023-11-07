package Exception;

public class WinningNumberContainsBonusNumberException extends IllegalArgumentException {
    private static final String ERROR = "[ERROR] 보너스 번호는 당첨 번호에 존재하지 않는 번호여야합니다.";

    public WinningNumberContainsBonusNumberException() {
        super(ERROR);
    }
}
