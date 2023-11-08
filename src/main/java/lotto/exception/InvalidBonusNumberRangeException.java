package lotto.exception;

public class InvalidBonusNumberRangeException extends IllegalArgumentException {
    public InvalidBonusNumberRangeException() {
        super("[ERROR] 보너스 넘버는 1~45 사이의 숫자만 입력할 수 있습니다.");
    }
}
