package lotto.exception;

public class DuplicateNumberException extends IllegalArgumentException {
    public DuplicateNumberException() {
        super("[ERROR] 중복되지않는 숫자를 입력해 주세요.\n");
    }
}
