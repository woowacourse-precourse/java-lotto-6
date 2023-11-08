package lotto.exception;

public class InvalidWinningNumbersSizeException extends IllegalArgumentException {
    public InvalidWinningNumbersSizeException() {
        super("[ERROR] 당첨 번호는 6개의 숫자로 입력할 수 있습니다.");
    }
}
