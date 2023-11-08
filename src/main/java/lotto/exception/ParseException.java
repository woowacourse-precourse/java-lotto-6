package lotto.exception;

public class ParseException extends CustomException {
    public ParseException() {
        super("변환할 수 있는 정확한 값을 입력해 주세요.");
    }
}
