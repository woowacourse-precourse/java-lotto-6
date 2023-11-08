package lotto.exception;

public class ParseIntException extends CustomException {
    public ParseIntException() {
        super("정수 범위 내에서 변환할 수 있는 정확한 값을 입력해 주세요.");
    }
}
