package lotto.domain.exception;

public class NotDigitException extends IllegalArgumentException {
    public NotDigitException() {
        super("[ERROR] 숫자만 입력해야 합니다.\n");
    }
}

