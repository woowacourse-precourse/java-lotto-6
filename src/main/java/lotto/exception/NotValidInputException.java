package lotto.exception;

// 사용자가 유효하지 않은 값을 입력하는 경우, 발생시킬 예외 클래스
public class NotValidInputException extends IllegalArgumentException {
    public NotValidInputException(String message) {
        super(message);
    }
}
