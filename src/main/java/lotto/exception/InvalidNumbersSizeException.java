package lotto.exception;

public class InvalidNumbersSizeException extends IllegalArgumentException {
    public InvalidNumbersSizeException() {
        super("[ERROR] 6개의 숫자를 입력해 주세요.\n");
    }
}
