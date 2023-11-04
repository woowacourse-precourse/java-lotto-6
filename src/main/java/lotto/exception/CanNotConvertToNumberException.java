package lotto.exception;

public class CanNotConvertToNumberException extends IllegalArgumentException {

    public CanNotConvertToNumberException(final String text) {
        super("[ERROR]" + text + "를(을) 정수로 변환할 수 없습니다.");
    }
}
