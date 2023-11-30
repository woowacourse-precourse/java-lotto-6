package lotto.exception;

public class InvalidNumberFormatException extends IllegalArgumentException {
    public InvalidNumberFormatException() {
        super("[ERROR] 숫자만 입력해 주세요.\n");
    }
}
