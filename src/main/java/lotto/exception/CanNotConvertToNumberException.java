package lotto.exception;

public class CanNotConvertToNumberException extends IllegalArgumentException {

    public CanNotConvertToNumberException(final String text) {
        super("[ERROR]" + text + "에는 정수로 변환 불가능한 값이 존재합니다.");
    }
}
