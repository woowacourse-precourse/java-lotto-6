package lotto.exception;

public class MissingWinningNumbersException extends IllegalArgumentException {
    public MissingWinningNumbersException() {
        super("[ERROR] 당첨 번호는 공백일 수 없습니다.\n");
    }
}