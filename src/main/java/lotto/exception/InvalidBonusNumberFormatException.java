package lotto.exception;

public class InvalidBonusNumberFormatException extends IllegalArgumentException {
    public InvalidBonusNumberFormatException() {
        super("[ERROR] 보너스 넘버는 숫자만 입력할 수 있습니다.\n");
    }
}
