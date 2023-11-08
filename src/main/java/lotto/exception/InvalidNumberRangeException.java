package lotto.exception;

public class InvalidNumberRangeException extends IllegalArgumentException {
    public InvalidNumberRangeException() {
        super("[ERROR] 입력 값은 1~45 사이에 숫자만 입력해 주세요.\n");
    }
}
