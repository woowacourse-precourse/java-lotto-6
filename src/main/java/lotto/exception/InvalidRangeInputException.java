package lotto.exception;

public class InvalidRangeInputException extends LottoIllegalArgumentException {
    public InvalidRangeInputException() {
        super("허용 범위를 벗어난 입력입니다.");
    }
}
