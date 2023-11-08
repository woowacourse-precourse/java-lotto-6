package lotto.exception;

public class InvalidWinningNumbersFormatException extends IllegalArgumentException {
    public InvalidWinningNumbersFormatException() {
        super("[ERROR] 당첨 번호는 숫자와 ,(쉼표)로만 입력할 수 있습니다.");
    }
}
