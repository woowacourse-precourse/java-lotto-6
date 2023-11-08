package lotto.exception;

public class InvalidWinningNumberRangeException extends IllegalArgumentException {
    public InvalidWinningNumberRangeException() {
        super("[ERROR] 당첨 번호는 1~45 사이에 숫자만 입력할 수 있습니다.");
    }
}
