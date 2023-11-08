package lotto.exception;

public class DuplicateWinningNumbersException extends IllegalArgumentException {
    public DuplicateWinningNumbersException() {
        super("[ERROR] 당첨 번호는 중복될 수 없습니다.");
    }
}
