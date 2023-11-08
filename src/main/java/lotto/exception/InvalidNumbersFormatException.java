package lotto.exception;

public class InvalidNumbersFormatException extends IllegalArgumentException {
    public InvalidNumbersFormatException() {
        super("[ERROR] 입력 값은 숫자와 ,(쉼표)로만 입력해 주세요.\n");
    }
}
